package tr.edu.itu.cs.hca;

import java.util.List;


public interface ILocationCollection {
    public List<Location> getLocations();

    public void addLocation(Location aLocation);

    public void deleteLocation(Location aLocation);

    public void updateLocation(Location aLocation);
}
