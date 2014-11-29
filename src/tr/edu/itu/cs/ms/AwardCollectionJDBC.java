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


public class AwardCollectionJDBC implements IAwardCollection {
    private Connection _db;

    public AwardCollectionJDBC() {
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

    public List<Award> getAwards() {
        List<Award> awards = new LinkedList<Award>();
        try {
            String query = "SELECT id, name,owner, year FROM AWARD";
            Statement statement = this._db.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                Integer id = results.getInt("id");
                String name = results.getString("name");
                Integer year = results.getInt("year");
                String owner = results.getString("owner");

                Award award = new Award(name, owner, year);
                award.setId(id);
                awards.add(award);
            }
            results.close();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
        return awards;
    }

    public void addAward(Award award) {
        try {
            String query = "INSERT INTO AWARD(name, owner,year) VALUES(?,?,?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, award.getName());
            statement.setInt(3, award.getYear());
            statement.setString(2, award.getOwner());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void deleteAward(Award award) {
        try {
            String query = "DELETE FROM AWARD WHERE (id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setInt(1, award.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void updateAward(Award award) {
        try {
            String query = "UPDATE AWARD SET name = ?, owner = ?, year = ? WHERE(id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, award.getName());
            statement.setInt(3, award.getYear());
            statement.setString(2, award.getOwner());
            statement.setInt(4, award.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }
}
