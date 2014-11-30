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


public class ExhibitionCollectionJDBC implements IExhibitionCollection {
    private Connection _db;

    public ExhibitionCollectionJDBC() {
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

    public List<Exhibition> getExhibitions() {
        List<Exhibition> exhibitions = new LinkedList<Exhibition>();
        try {
            String query = "SELECT id, name, year, location FROM EXHIBITION";
            Statement statement = this._db.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                Integer id = results.getInt("id");
                String name = results.getString("name");
                Integer year = results.getInt("year");
                String location = results.getString("location");

                Exhibition exhibition = new Exhibition(name, location, year);
                exhibition.setId(id);
                exhibitions.add(exhibition);
            }
            results.close();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
        return exhibitions;
    }

    public void addExhibition(Exhibition exhibition) {
        try {
            String query = "INSERT INTO EXHIBITION(name,year, location) VALUES(?,?,?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, exhibition.getName());
            statement.setInt(2, exhibition.getYear());
            statement.setString(3, exhibition.getLocation());
            statement.executeUpdate();
            statement.close();

            query = "INSERT INTO UPDATES(desc) VALUES(?)";
            statement = this._db.prepareStatement(query);
            String desc = "Added " + exhibition.getName();
            statement.setString(1, desc);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void deleteExhibition(Exhibition exhibition) {
        try {
            String query = "DELETE FROM EXHIBITION WHERE (id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setInt(1, exhibition.getId());
            statement.executeUpdate();
            statement.close();

            query = "INSERT INTO UPDATES(desc) VALUES(?)";
            statement = this._db.prepareStatement(query);
            String desc = "Deleted " + exhibition.getName();
            statement.setString(1, desc);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void updateExhibition(Exhibition exhibition) {
        try {
            String query = "UPDATE EXHIBITION SET name = ?, year = ?, location = ? WHERE(id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, exhibition.getName());
            statement.setInt(2, exhibition.getYear());
            statement.setString(3, exhibition.getLocation());
            statement.setInt(5, exhibition.getId());
            statement.executeUpdate();
            statement.close();

            query = "INSERT INTO UPDATES(desc) VALUES(?)";
            statement = this._db.prepareStatement(query);
            String desc = "Updated " + exhibition.getName();
            statement.setString(1, desc);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }
}
