package tr.edu.itu.cs.hca;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import tr.edu.itu.cs.db.BasePage;
import tr.edu.tr.cs.sh.Painting;
import tr.edu.tr.cs.sh.PaintingDetailPageLink;


public final class LocationDetailPage extends BasePage {
    private Location _location;

    public LocationDetailPage(Location aLocation) {
        this._location = aLocation;

        this.add(new Label("name", aLocation.getName()));
        this.add(new Label("city", aLocation.getCity()));
        this.add(new Label("desc", aLocation.getDesc()));

        PaintingListGeneratorJDBC listgenerator = new PaintingListGeneratorJDBC();
        List<Painting> paintings = listgenerator.getPaintings(_location
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
                LocationDetailPage parent = (LocationDetailPage) this
                        .getParent();
                this.setResponsePage(new LocationEditPage(parent.getLocation(),
                        false));
            }
        };
        this.add(editLink);
    }

    public Location getLocation() {
        return this._location;
    }
}
