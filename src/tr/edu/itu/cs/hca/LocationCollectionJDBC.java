package tr.edu.itu.cs.hca;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class LocationCollectionJDBC implements ILocationCollection {
    private Connection _db;

    public LocationCollectionJDBC() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }

        try {
            String sqlite = "jdbc:sqlite:";
            String home = System.getProperty("user.home");
            String jdbcURL = sqlite + home + File.separator + "painters.sqlite";
            this._db = DriverManager.getConnection(jdbcURL);
        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
    }

    public List<Location> getLocations() {
        List<Location> locations = new LinkedList<Location>();
        try {
            String query = "SELECT id, name, city, desc FROM LOCATION";
            Statement statement = this._db.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                Integer id = results.getInt("id");
                String name = results.getString("name");
                String city = results.getString("city");
                String desc = results.getString("desc");

                Location location = new Location(name, desc, city);
                location.setId(id);

                /*
                 * query =
                 * "SELECT name, year, painter, desc, place, idiom FROM PAINTING WHERE(place = ?)"
                 * ; PreparedStatement statement2 =
                 * this._db.prepareStatement(query); statement2.setString(1,
                 * name); ResultSet results2 = statement2.executeQuery(); while
                 * (results2.next()) { String pname =
                 * results2.getString("name"); Integer pyear =
                 * results2.getInt("year"); String ppainter =
                 * results2.getString("painter"); String pdesc =
                 * results2.getString("desc"); String pplace =
                 * results2.getString("place"); String pidiom =
                 * results2.getString("idiom");
                 * 
                 * Painting painting = new Painting(pname, pyear, ppainter,
                 * pdesc, pplace, pidiom); location.addPainting(painting);
                 * 
                 * }
                 * 
                 * statement2.close(); results2.close();
                 */

                locations.add(location);
            }
            results.close();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
        return locations;
    }

    public void addLocation(Location location) {
        try {
            String query = "INSERT INTO LOCATION(name,city, desc) VALUES(?,?,?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, location.getName());
            statement.setString(2, location.getCity());
            statement.setString(3, location.getDesc());
            statement.executeUpdate();
            statement.close();

            query = "INSERT INTO UPDATES(desc) VALUES(?)";
            statement = this._db.prepareStatement(query);
            String desc = "Added " + location.getName();
            statement.setString(1, desc);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void deleteLocation(Location location) {
        try {
            String query = "DELETE FROM LOCATION WHERE (id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setInt(1, location.getId());
            statement.executeUpdate();
            statement.close();

            query = "INSERT INTO UPDATES(desc) VALUES(?)";
            statement = this._db.prepareStatement(query);
            String desc = "Deleted " + location.getName();
            statement.setString(1, desc);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void updateLocation(Location location) {
        try {
            String query = "UPDATE LOCATION SET name = ?, city = ?, desc = ? WHERE(id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, location.getName());
            statement.setString(2, location.getCity());
            statement.setString(3, location.getDesc());
            statement.setInt(4, location.getId());
            statement.executeUpdate();
            statement.close();

            query = "INSERT INTO UPDATES(desc) VALUES(?)";
            statement = this._db.prepareStatement(query);
            String desc = "Updated " + location.getName();
            statement.setString(1, desc);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }
}
