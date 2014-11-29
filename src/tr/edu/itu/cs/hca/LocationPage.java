package tr.edu.itu.cs.hca;

import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;


public class LocationPage extends BasePage {
    public LocationPage() {
        Link locationAddLink = new Link("add_location") {
            @Override
            public void onClick() {
                Location location = new Location("");
                this.setResponsePage(new LocationEditPage(location));
            }
        };
        this.add(locationAddLink);

        LocationForm locationForm = new LocationForm("location_form");
        this.add(locationForm);
    }
}
