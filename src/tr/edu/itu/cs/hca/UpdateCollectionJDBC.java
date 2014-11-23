package tr.edu.itu.cs.hca;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class UpdateCollectionJDBC implements IUpdateCollection {
    private Connection _db;

    public UpdateCollectionJDBC() {
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

    public List<Update> getUpdates() {
        List<Update> updates = new LinkedList<Update>();
        try {
            String query = "SELECT desc FROM UPDATES";
            Statement statement = this._db.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                String desc = results.getString("desc");

                Update update = new Update(desc);
                updates.add(update);
            }
            results.close();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
        return updates;
    }

    public void addUpdate(Update update) {
        try {
            String query = "INSERT INTO UPDATES(desc) VALUES(?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, update.getDesc());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }
}
