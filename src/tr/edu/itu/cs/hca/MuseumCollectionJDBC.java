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


public class MuseumCollectionJDBC implements IMuseumCollection {
    private Connection _db;

    public MuseumCollectionJDBC() {
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

    public List<Museum> getMuseums() {
        List<Museum> museums = new LinkedList<Museum>();
        try {
            String query = "SELECT id, name, year, location, desc FROM MUSEUM";
            Statement statement = this._db.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                Integer id = results.getInt("id");
                String name = results.getString("name");
                Integer year = results.getInt("year");
                String location = results.getString("location");
                String desc = results.getString("desc");

                Museum museum = new Museum(name, desc, location, year);
                museum.setId(id);

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
                 * pdesc, pplace, pidiom); museum.addPainting(painting);
                 * 
                 * }
                 * 
                 * statement2.close(); results2.close();
                 */
                museums.add(museum);

            }
            results.close();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
        return museums;
    }

    public void addMuseum(Museum museum) {
        try {
            String query = "INSERT INTO MUSEUM(name,year, location, desc) VALUES(?,?,?,?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, museum.getName());
            statement.setInt(2, museum.getYear());
            statement.setString(3, museum.getLocation());
            statement.setString(4, museum.getDesc());
            statement.executeUpdate();
            statement.close();

            query = "INSERT INTO UPDATES(desc) VALUES(?)";
            statement = this._db.prepareStatement(query);
            String desc = "Added " + museum.getName();
            statement.setString(1, desc);
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void deleteMuseum(Museum museum) {
        try {
            String query = "DELETE FROM MUSEUM WHERE (id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setInt(1, museum.getId());
            statement.executeUpdate();
            statement.close();

            query = "INSERT INTO UPDATES(desc) VALUES(?)";
            statement = this._db.prepareStatement(query);
            String desc = "Deleted " + museum.getName();
            statement.setString(1, desc);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void updateMuseum(Museum museum) {
        try {
            String query = "UPDATE MUSEUM SET name = ?, year = ?, location = ?, desc = ? WHERE(id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, museum.getName());
            statement.setInt(2, museum.getYear());
            statement.setString(3, museum.getLocation());
            statement.setString(4, museum.getDesc());
            statement.setInt(5, museum.getId());
            statement.executeUpdate();
            statement.close();

            query = "INSERT INTO UPDATES(desc) VALUES(?)";
            statement = this._db.prepareStatement(query);
            String desc = "Updated " + museum.getName();
            statement.setString(1, desc);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }
}
