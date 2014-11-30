package tr.edu.tr.cs.sh;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import tr.edu.itu.cs.db.BasePage;
//import tr.edu.itu.cs.hca.PaintingListGeneratorJDBC;


public final class IdiomDetailPage extends BasePage {

    private Idiom _idiom;

    public IdiomDetailPage(Idiom aIdiom) {
        this._idiom = aIdiom;

        this.add(new Label("name", aIdiom.getName()));
        this.add(new Label("year", Integer.toString(aIdiom.getYear())));
        this.add(new Label("location", aIdiom.getLocation()));

        this.add(new Label("desc", aIdiom.getDesc()));

        PaintingListGeneratorJDBC listgenerator = new PaintingListGeneratorJDBC();
        List<Painting> paintings = listgenerator.getPaintings(_idiom.getName());

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
                IdiomDetailPage parent = (IdiomDetailPage) this.getParent();
                this.setResponsePage(new IdiomEditPage(parent.getIdiom(), false));
            }
        };
        this.add(editLink);
    }

    public Idiom getIdiom() {
        return this._idiom;
    }
}
