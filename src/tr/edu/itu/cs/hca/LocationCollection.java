package tr.edu.itu.cs.hca;

import java.util.LinkedList;
import java.util.List;


public class LocationCollection implements ILocationCollection {
    private LocationCollectionJDBC jdbc;
    private List<Location> locations;

    public LocationCollection() {
        jdbc = new LocationCollectionJDBC();
        this.locations = new LinkedList<Location>();
        locations = jdbc.getLocations();
    }

    public List<Location> getLocations() {
        return this.locations;
    }

    public void addLocation(Location aLocation) {
        this.locations.add(aLocation);
        jdbc.addLocation(aLocation);
    }

    public void deleteLocation(Location aLocation) {
        this.locations.remove(aLocation);
        jdbc.deleteLocation(aLocation);
    }

    public void updateLocation(Location aLocation) {
        jdbc.updateLocation(aLocation);
    }
}
