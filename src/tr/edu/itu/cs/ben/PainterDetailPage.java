package tr.edu.itu.cs.ben;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import tr.edu.itu.cs.db.BasePage;
import tr.edu.tr.cs.sh.Painting;
import tr.edu.tr.cs.sh.PaintingDetailPageLink;


public final class PainterDetailPage extends BasePage {
    private Painter _painter;

    public PainterDetailPage(Painter aPainter) {
        this._painter = aPainter;

        this.add(new Label("name", aPainter.getName()));
        this.add(new Label("country", aPainter.getCountry()));
        this.add(new Label("age", Integer.toString(aPainter.getAge())));
        this.add(new Label("biography", aPainter.getBiography()));
        this.add(new Label("comment", aPainter.getComment()));
        this.add(new Label("award", aPainter.getAward()));
        this.add(new Label("idiom", aPainter.getIdiom()));

        PaintingListGeneratorJDBC listgenerator = new PaintingListGeneratorJDBC();
        List<Painting> paintings = listgenerator.getPaintings(_painter
                .getName());

        PropertyListView paintingListView = new PropertyListView(
                "painting_list", paintings) {
            @Override
            protected void populateItem(ListItem item) {
                Painting painting = (Painting) item.getModelObject();
                PaintingDetailPageLink paintingLink = new PaintingDetailPageLink(
                        "painting_link", painting);
                paintingLink.add(new Label("pname", painting.getName()));
                item.add(paintingLink);
            }
        };
        this.add(paintingListView);

        Link editLink = new Link("edit_link") {
            @Override
            public void onClick() {
                PainterDetailPage parent = (PainterDetailPage) this.getParent();
                this.setResponsePage(new PainterEditPage(parent.getPainter(),
                        false));
            }
        };
        this.add(editLink);
    }

    public Painter getPainter() {
        return this._painter;
    }
}
