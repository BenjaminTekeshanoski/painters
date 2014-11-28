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


public class IdiomCollectionJDBC implements IIdiomCollection {

    private Connection _db;

    public IdiomCollectionJDBC() {
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

    public List<Idiom> getIdioms() {
        List<Idiom> idioms = new LinkedList<Idiom>();
        try {
            String query = "SELECT id, name, year, location, desc FROM IDIOM";
            Statement statement = this._db.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                Integer id = results.getInt("id");
                String name = results.getString("name");
                Integer year = results.getInt("year");
                String location = results.getString("location");
                String desc = results.getString("desc");

                // String nameOfPr = results.getString("nameOfPr");
                Idiom idiom = new Idiom(name, year, location, desc);
                idiom.setId(id);
                idioms.add(idiom);

            }
            results.close();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());

        }
        return idioms;
    }

    public void addIdiom(Idiom Idiom) {
        try {
            String query = "INSERT INTO IDIOM( name , year , location, desc) VALUES(?,?,?,?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, Idiom.getName());
            statement.setInt(2, Idiom.getYear());
            statement.setString(3, Idiom.getLocation());
            statement.setString(4, Idiom.getDesc());

            // statement.setString(4, Idiom.);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());

        }
    }

    public void deleteIdiom(Idiom idiom) {
        try {
            String query = "DELETE FROM IDIOM WHERE (id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setInt(1, idiom.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void updateIdiom(Idiom idiom) {
        try {
            String query = "UPDATE IDIOM SET name = ?, year = ? , location=?, desc=? WHERE(id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, idiom.getName());
            statement.setInt(2, idiom.getYear());
            statement.setString(3, idiom.getLocation());
            statement.setString(4, idiom.getDesc());
            statement.setInt(5, idiom.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }

    }
}
