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


public class PainterCollectionJDBC implements IPainterCollection {
    private Connection _db;

    public PainterCollectionJDBC() {
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

    public List<Painter> getPainters() {
        List<Painter> painters = new LinkedList<Painter>();
        try {
            String query = "SELECT id, name, year, location, desc FROM PAINTER";
            Statement statement = this._db.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                Integer id = results.getInt("id");
                String name = results.getString("name");
                Integer year = results.getInt("year");
                String location = results.getString("location");
                String desc = results.getString("desc");

                Painter painter = new Painter(name, desc, location, year);
                painter.setId(id);
                painters.add(painter);
            }
            results.close();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
        return painters;
    }

    public void addPainter(Painter painter) {
        try {
            String query = "INSERT INTO PAINTER(name,year, location, desc) VALUES(?,?,?,?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, painter.getName());
            statement.setInt(2, painter.getYear());
            statement.setString(3, painter.getLocation());
            statement.setString(4, painter.getDesc());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void deletePainter(Painter painter) {
        try {
            String query = "DELETE FROM PAINTER WHERE (id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setInt(1, painter.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void updatePainter(Painter painter) {
        try {
            String query = "UPDATE PAINTER SET name = ?, year = ?, location = ?, desc = ? WHERE(id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, painter.getName());
            statement.setInt(2, painter.getYear());
            statement.setString(3, painter.getLocation());
            statement.setString(4, painter.getDesc());
            statement.setInt(5, painter.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }
}
