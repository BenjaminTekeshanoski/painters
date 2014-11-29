package tr.edu.itu.cs.hca;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import tr.edu.itu.cs.db.BasePage;
import tr.edu.tr.cs.sh.Painting;
import tr.edu.tr.cs.sh.PaintingDetailPageLink;


public final class MuseumDetailPage extends BasePage {
    private Museum _museum;

    public MuseumDetailPage(Museum aMuseum) {
        this._museum = aMuseum;

        this.add(new Label("name", aMuseum.getName()));
        this.add(new Label("location", aMuseum.getLocation()));
        this.add(new Label("year", Integer.toString(aMuseum.getYear())));
        this.add(new Label("desc", aMuseum.getDesc()));

        PaintingListGeneratorJDBC listgenerator = new PaintingListGeneratorJDBC();
        List<Painting> paintings = listgenerator
                .getPaintings(_museum.getName());

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
                MuseumDetailPage parent = (MuseumDetailPage) this.getParent();
                this.setResponsePage(new MuseumEditPage(parent.getMuseum(),
                        false));
            }
        };
        this.add(editLink);
    }

    public Museum getMuseum() {
        return this._museum;
    }
}
