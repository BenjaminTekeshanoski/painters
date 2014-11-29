package tr.edu.itu.cs.critic;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Critic {
    private String Result;

    public Critic(int subjectID) {

        Connection _db = null;
        String sqlite = "jdbc:sqlite:";
        String home = System.getProperty("user.home");
        String jdbcURL = sqlite + home + File.separator + "painters.sqlite";
        try {
            _db = DriverManager.getConnection(jdbcURL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        try {
            statement = _db.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query = "Select * from critics inner join reviewer on reviewer.id=critics.reviewerid where SUBJECT="
                + subjectID;
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String output = "";
        try {
            while (rs.next()) {
                output += (rs.getString("fullname") + " :\n "
                        + rs.getString("CRITIC") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Result = output;
    }

    public String getResult() {
        return Result;
    }
}
