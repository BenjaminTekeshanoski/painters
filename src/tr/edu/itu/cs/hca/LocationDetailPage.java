package tr.edu.itu.cs.hca;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;


public final class LocationDetailPage extends BasePage {
    private Location _location;

    public LocationDetailPage(Location aLocation) {
        this._location = aLocation;

        this.add(new Label("name", aLocation.getName()));
        this.add(new Label("city", aLocation.getCity()));
        this.add(new Label("desc", aLocation.getDesc()));

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
