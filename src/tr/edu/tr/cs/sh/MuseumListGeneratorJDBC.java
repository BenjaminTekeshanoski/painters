package tr.edu.tr.cs.sh;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tr.edu.itu.cs.hca.Museum;


public class MuseumListGeneratorJDBC {
    private Connection _db;

    public MuseumListGeneratorJDBC() {
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

    public Museum getMuseums(String aName) {
        // List<Museum> museums = new LinkedList<Museum>();
        Museum museum = new Museum();
        try {

            String query = "SELECT name, year, location, desc FROM MUSEUM WHERE(name = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, aName);
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                String pname = results.getString("name");
                Integer pyear = results.getInt("year");
                String plocation = results.getString("location");
                String pdesc = results.getString("desc");
                /*
                 * String pplace = results.getString("place"); String pidiom =
                 * results.getString("idiom");
                 */

                museum.setName(pname);
                museum.setDesc(pdesc);
                museum.setLocation(plocation);
                museum.setYear(pyear);
                // museums.add(museum);

                statement.close();
                results.close();
                return museum;

            }

        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
        museum = new Museum();
        return museum;
    }
}
