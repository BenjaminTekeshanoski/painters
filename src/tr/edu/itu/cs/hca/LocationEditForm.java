package tr.edu.itu.cs.hca;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import tr.edu.itu.cs.db.WicketApplication;
import tr.edu.itu.cs.users.User;


public class LocationEditForm extends Form {
    private boolean newLocation;

    public LocationEditForm(String id, Location aLocation,
            boolean newLocationFlag) {
        super(id);
        CompoundPropertyModel model = new CompoundPropertyModel(aLocation);
        this.setModel(model);

        this.add(new TextField("name"));
        this.add(new TextField("city"));
        this.add(new TextField("desc"));

        this.newLocation = newLocationFlag;
    }

    @Override
    public void onSubmit() {
        Location location = (Location) this.getModelObject();
        WicketApplication app = (WicketApplication) this.getApplication();
        ILocationCollection collection = app.getLocationCollection();

        if (this.newLocation) {
            collection.addLocation(location);
        } else {
            collection.updateLocation(location);
        }
        if (User.user.getAccesslevel() < 3) {
            this.setResponsePage(new LocationDetailPageUser(location));
        } else {
            this.setResponsePage(new LocationDetailPage(location));
        }
    }
}
