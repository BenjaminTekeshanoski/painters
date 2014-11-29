package tr.edu.itu.cs.hca;

import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.users.User;


public class LocationDetailPageLink extends Link {
    private Location _location;

    public LocationDetailPageLink(String id, Location location) {
        super(id);
        this._location = location;
    }

    @Override
    public void onClick() {
        if (User.user.getAccesslevel() < 3) {
            this.setResponsePage(new LocationDetailPageUser(this._location));
        } else {
            this.setResponsePage(new LocationDetailPage(this._location));
        }
    }
}
