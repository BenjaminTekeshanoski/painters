package tr.edu.itu.cs.ben;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import tr.edu.tr.cs.sh.Painting;


public class PaintingListGeneratorJDBC {
    private Connection _db;

    public PaintingListGeneratorJDBC() {
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

    public List<Painting> getPaintings(String aName) {
        List<Painting> paintings = new LinkedList<Painting>();
        try {
            String query = "SELECT id, name, year, painter, desc, place, idiom FROM PAINTING WHERE(painter = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, aName);
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                String pname = results.getString("name");
                Integer pyear = results.getInt("year");
                String ppainter = results.getString("painter");
                String pdesc = results.getString("desc");
                String pplace = results.getString("place");
                String pidiom = results.getString("idiom");
                Integer pid = results.getInt("id");

                Painting painting = new Painting(pname, pyear, ppainter, pdesc,
                        pplace, pidiom);
                painting.setId(pid);
                paintings.add(painting);

            }

            statement.close();
            results.close();
            return paintings;
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }
}
