package tr.edu.itu.cs.users;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RegisteredUser extends User {
    private boolean onlineStatus;
    private static int numberOfRegisteredUsers;

    public static String CreateNewUser(String name, String surname,
            String nickname, String password) {
        Connection _db = null;
        String sqlite = "jdbc:sqlite:";
        String home = System.getProperty("user.home");
        String jdbcURL = sqlite + home + File.separator + "painters.sqlite";
        try {
            _db = DriverManager.getConnection(jdbcURL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "SELECT nickname FROM USERS WHERE nickname='" + nickname
                + "'";
        Statement statement = null;
        try {
            statement = _db.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("1part");
        }
        try {
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                return "Nickname already used please change nick name";
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("2part");
        }
        try {
            Statement statement2 = _db.createStatement();
            query = "insert into USERS (name,surname,nickname,password,AccessLevel) values ("
                    + "'"
                    + name
                    + "'"
                    + ","
                    + "'"
                    + surname
                    + "'"
                    + ","
                    + "'"
                    + nickname + "'" + "," + "'" + password + "'" + ",2)";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("3part");
        }
        return "You are registered";

    }

    public static String loginUser(String nickname, String password) {
        Connection _db = null;
        String sqlite = "jdbc:sqlite:";
        String home = System.getProperty("user.home");
        String jdbcURL = sqlite + home + File.separator + "painters.sqlite";

        try {
            _db = DriverManager.getConnection(jdbcURL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query = "SELECT * FROM USERS WHERE nickname='" + nickname + "'"
                + "and password='" + password + "'";
        Statement statement = null;
        try {
            statement = _db.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("1part");
        }

        try {
            final ResultSet results = statement.executeQuery(query);

            while (results.next()) {

                new RegisteredUser(results.getString("name"),
                        results.getString("surname"),
                        results.getString("nickname"),
                        results.getString("password"),
                        results.getInt("AccessLevel"));
                String nn = results.getString("nickname");
                results.close();
                statement.close();
                return "Welcome " + nn;
            }
            results.close();
            statement.close();
        } catch (SQLException e) { // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("2part");
        }
        return "Nickname/password mismatch";
    }

    public RegisteredUser(String name, String surname, String nickname,
            String password, int AccesLevel) {

        super(name, surname, password, nickname, AccesLevel);

    }

}
