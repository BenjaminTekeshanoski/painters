package tr.edu.itu.cs.ms;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class PmediaCollectionJDBC implements IPmediaCollection {
    private Connection _db;

    public PmediaCollectionJDBC() {
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

    public List<Pmedia> getPmedias() {
        List<Pmedia> pmedias = new LinkedList<Pmedia>();
        try {
            String query = "SELECT id, name, desc FROM PMEDÝA";
            Statement statement = this._db.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                Integer id = results.getInt("id");
                String name = results.getString("name");
                String desc = results.getString("desc");

                Pmedia pmedia = new Pmedia(name, desc);
                pmedia.setId(id);
                pmedias.add(pmedia);
            }
            results.close();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
        return pmedias;
    }

    public void addPmedia(Pmedia pmedia) {
        try {
            String query = "INSERT INTO PMEDÝA(name, desc) VALUES(?,?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, pmedia.getName());
            statement.setString(2, pmedia.getDesc());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void deletePmedia(Pmedia pmedia) {
        try {
            String query = "DELETE FROM PMEDÝA WHERE (id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setInt(1, pmedia.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void updatePmedia(Pmedia pmedia) {
        try {
            String query = "UPDATE PMEDÝA SET name = ?, desc = ? WHERE(id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, pmedia.getName());
            statement.setString(2, pmedia.getDesc());
            statement.setInt(3, pmedia.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }
}
