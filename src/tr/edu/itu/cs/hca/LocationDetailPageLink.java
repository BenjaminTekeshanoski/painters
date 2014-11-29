package tr.edu.itu.cs.hca;

import org.apache.wicket.markup.html.link.Link;


public class LocationDetailPageLink extends Link {
    private Location _location;

    public LocationDetailPageLink(String id, Location location) {
        super(id);
        this._location = location;
    }

    @Override
    public void onClick() {
        this.setResponsePage(new LocationDetailPage(this._location));
    }
}
