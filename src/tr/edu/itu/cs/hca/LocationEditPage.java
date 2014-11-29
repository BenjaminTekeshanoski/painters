package tr.edu.itu.cs.hca;

import tr.edu.itu.cs.db.BasePage;


public final class LocationEditPage extends BasePage {
    public LocationEditPage(Location aLocation) {
        this.add(new LocationEditForm("location_edit", aLocation, true));
    }

    public LocationEditPage(Location aLocation, boolean newLocationFlag) {
        this.add(new LocationEditForm("location_edit", aLocation,
                newLocationFlag));
    }
}
