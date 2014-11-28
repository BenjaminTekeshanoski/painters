package tr.edu.tr.cs.sh;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class YourPaintingCollectionJDBC implements IYourPaintingCollection {

    private Connection _db;

    public YourPaintingCollectionJDBC() {
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

    public List<YourPainting> getYourPaintings() {
        List<YourPainting> yourPaintings = new LinkedList<YourPainting>();
        try {
            String query = "SELECT id, name, year, location, desc FROM YOURPAINTING";
            Statement statement = this._db.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                Integer id = results.getInt("id");
                String name = results.getString("name");
                Integer year = results.getInt("year");
                String location = results.getString("location");
                String desc = results.getString("desc");

                // String nameOfPr = results.getString("nameOfPr");
                YourPainting yourPainting = new YourPainting(name, year,
                        location, desc);
                yourPainting.setId(id);
                yourPaintings.add(yourPainting);

            }
            results.close();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());

        }
        return yourPaintings;
    }

    public void addYourPainting(YourPainting YourPainting) {
        try {
            String query = "INSERT INTO YOURPAINTING( name , year , location, desc) VALUES(?,?,?,?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, YourPainting.getName());
            statement.setInt(2, YourPainting.getYear());
            statement.setString(3, YourPainting.getLocation());
            statement.setString(4, YourPainting.getDesc());

            // statement.setString(4, YourPainting.);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());

        }
    }

    public void deleteYourPainting(YourPainting yourPainting) {
        try {
            String query = "DELETE FROM YOURPAINTING WHERE (id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setInt(1, yourPainting.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void updateYourPainting(YourPainting yourPainting) {
        try {
            String query = "UPDATE YOURPAINTING SET name = ?, year = ? , location=?, desc=? WHERE(id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, yourPainting.getName());
            statement.setInt(2, yourPainting.getYear());
            statement.setString(3, yourPainting.getLocation());
            statement.setString(4, yourPainting.getDesc());
            statement.setInt(5, yourPainting.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }

    }
}
