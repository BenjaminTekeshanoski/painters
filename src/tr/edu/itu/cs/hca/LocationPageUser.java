package tr.edu.itu.cs.hca;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import tr.edu.itu.cs.db.BasePage;
import tr.edu.itu.cs.db.WicketApplication;


public class LocationPageUser extends BasePage {
    public LocationPageUser() {

        WicketApplication app = (WicketApplication) this.getApplication();
        ILocationCollection collection = app.getLocationCollection();
        List<Location> locations = collection.getLocations();

        PropertyListView locationListView = new PropertyListView(
                "location_list", locations) {
            @Override
            protected void populateItem(ListItem item) {
                Location location = (Location) item.getModelObject();
                LocationDetailPageLink locationLink = new LocationDetailPageLink(
                        "location_link", location);
                locationLink.add(new Label("name"));
                item.add(locationLink);
            }
        };
        this.add(locationListView);
    }
}
