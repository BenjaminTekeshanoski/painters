package tr.edu.itu.cs.critic;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;


public class Critic extends TextField {
    public Critic(String id, String subject, Model<String> model) {
        super(id, model);
        Connection _db = null;
        String sqlite = "jdbc:sqlite:";
        String home = System.getProperty("user.home");
        String jdbcURL = sqlite + home + File.separator + "painters.sqlite";
        try {
            _db = DriverManager.getConnection(jdbcURL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query = "SELECT * FROM CRITICS WHERE subject='" + subject
                + "' INNER JOIN REVIEWERS"
                + " ON CRITICS.REVIEWERID=REVIEWERS.id;";
        Statement statement = null;
        try {
            statement = _db.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("1part");
        }
        String output = null;
        try {
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                output += results.getString("FULLNAME") + ":\n";
                output += results.getString("CRITIC") + "\n";
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("2part");
        }
        model.setObject(output);
    }
}
