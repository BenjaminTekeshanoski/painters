package tr.edu.itu.cs.ben;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class PaintingStyleCollectionJDBC implements IPaintingStyleCollection {
    private Connection _db;

    public PaintingStyleCollectionJDBC() {
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

    public List<PaintingStyle> getPaintingStyles() {
        List<PaintingStyle> paintingstyles = new LinkedList<PaintingStyle>();
        try {
            String query = "SELECT id, paintname, year, stylename, desc FROM PAINTINGSTYLE";
            Statement statement = this._db.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                Integer id = results.getInt("id");
                String paintname = results.getString("paintname");
                Integer year = results.getInt("year");
                String stylename = results.getString("stylename");
                String desc = results.getString("desc");

                PaintingStyle paintingstyle = new PaintingStyle(paintname,
                        desc, stylename, year);
                paintingstyle.setId(id);
                paintingstyles.add(paintingstyle);
            }
            results.close();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
        return paintingstyles;
    }

    public void addPaintingStyle(PaintingStyle paintingstyle) {
        try {
            String query = "INSERT INTO PAINTINGSTYLE(paintname,year, stylename, desc) VALUES(?,?,?,?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, paintingstyle.getPaintname());
            statement.setInt(2, paintingstyle.getYear());
            statement.setString(3, paintingstyle.getStylename());
            statement.setString(4, paintingstyle.getDesc());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void deletePaintingStyle(PaintingStyle paintingstyle) {
        try {
            String query = "DELETE FROM PAINTINGSTYLE WHERE (id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setInt(1, paintingstyle.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void updatePaintingStyle(PaintingStyle paintingstyle) {
        try {
            String query = "UPDATE PAINTINGSTYLE SET paintname = ?, year = ?, stylename = ?, desc = ? WHERE(id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, paintingstyle.getPaintname());
            statement.setInt(2, paintingstyle.getYear());
            statement.setString(3, paintingstyle.getStylename());
            statement.setString(4, paintingstyle.getDesc());
            statement.setInt(5, paintingstyle.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }
}
