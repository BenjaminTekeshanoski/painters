package tr.edu.itu.cs.ben;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import tr.edu.itu.cs.db.BasePage;
import tr.edu.tr.cs.sh.Painting;
import tr.edu.tr.cs.sh.PaintingDetailPageLink;


public final class PaintingStyleDetailPage extends BasePage {
    private PaintingStyle _paintingstyle;

    public PaintingStyleDetailPage(PaintingStyle aPaintingStyle) {
        this._paintingstyle = aPaintingStyle;

        this.add(new Label("stylename", aPaintingStyle.getStylename()));
        this.add(new Label("paintname", aPaintingStyle.getPaintname()));
        this.add(new Label("year", Integer.toString(aPaintingStyle.getYear())));
        this.add(new Label("desc", aPaintingStyle.getDesc()));

        StylePaintingListGeneratorJDBC listgenerator = new StylePaintingListGeneratorJDBC();
        List<Painting> paintings = listgenerator.getPaintings(_paintingstyle
                .getPaintname());

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
                PaintingStyleDetailPage parent = (PaintingStyleDetailPage) this
                        .getParent();
                this.setResponsePage(new PaintingStyleEditPage(parent
                        .getPaintingStyle(), false));
            }
        };
        this.add(editLink);
    }

    public PaintingStyle getPaintingStyle() {
        return this._paintingstyle;
    }
}
