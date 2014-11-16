package tr.edu.itu.cs.hca;

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

    public MuseumCollectionJDBC(String dbFilePath) {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }

        try {
            String jdbcURL = "jdbc:sqlite:" + dbFilePath;
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
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }
}
