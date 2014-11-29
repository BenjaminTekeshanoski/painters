package tr.edu.itu.cs.hca;

import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Check;
import org.apache.wicket.markup.html.form.CheckGroup;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import tr.edu.itu.cs.db.WicketApplication;
import tr.edu.itu.cs.users.User;


public class LocationForm extends Form {
    private List<Location> selectedLocations;

    public LocationForm(String id) {
        super(id);
        this.selectedLocations = new LinkedList<Location>();
        CheckGroup locationCheckGroup = new CheckGroup("selected_locations",
                this.selectedLocations);
        this.add(locationCheckGroup);

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
                item.add(new Check("selected", item.getModel()));
                item.add(locationLink);
            }
        };
        locationCheckGroup.add(locationListView);
    }

    @Override
    public void onSubmit() {
        WicketApplication app = (WicketApplication) this.getApplication();
        ILocationCollection collection = app.getLocationCollection();
        for (Location location : this.selectedLocations) {
            collection.deleteLocation(location);
        }
        if (User.user.getAccesslevel() < 3) {
            this.setResponsePage(new LocationPageUser());
        } else {
            this.setResponsePage(new LocationPage());
        }
    }
}
