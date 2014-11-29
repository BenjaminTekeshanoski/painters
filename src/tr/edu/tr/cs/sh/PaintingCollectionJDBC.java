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


public class PaintingCollectionJDBC-degis implements IPaintingCollection {

    private Connection _db;

    public PaintingCollectionJDBC() {
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

    public List<Painting> getPaintings() {
        List<Painting> paintings = new LinkedList<Painting>();
        try {
            String query = "SELECT id, name, year, painter, desc, place, idiom FROM PAINTING";
            Statement statement = this._db.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                Integer id = results.getInt("id");
                String name = results.getString("name");
                Integer year = results.getInt("year");
                String painter = results.getString("painter");
                String desc = results.getString("desc");
                String place = results.getString("place");
                String idiom = results.getString("idiom");
                // String nameOfPr = results.getString("nameOfPr");
                Painting painting = new Painting(name, year, painter, desc,
                        place, idiom);
                painting.setId(id);
                paintings.add(painting);

            }
            results.close();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());

        }
        return paintings;
    }

    public void addPainting(Painting Painting) {
        try {
            String query = "INSERT INTO PAINTING( name , year , painter, desc, place, idiom) VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, Painting.getName());
            statement.setInt(2, Painting.getYear());
            statement.setString(3, Painting.getPainter());
            statement.setString(4, Painting.getDesc());
            statement.setString(5, Painting.getPlace());
            statement.setString(6, Painting.getIdiom());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());

        }
    }

    public void deletePainting(Painting painting) {
        try {
            String query = "DELETE FROM PAINTING WHERE (id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setInt(1, painting.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void updatePainting(Painting painting) {
        try {
            String query = "UPDATE PAINTING SET name = ?, year = ? , painter=?, desc=?, place=?, idiom=? WHERE(id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, painting.getName());
            statement.setInt(2, painting.getYear());
            statement.setString(3, painting.getPainter());
            statement.setString(4, painting.getDesc());
            statement.setString(5, painting.getPlace());
            statement.setString(6, painting.getIdiom());
            statement.setInt(7, painting.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }

    }
}
