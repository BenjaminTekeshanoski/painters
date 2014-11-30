package tr.edu.tr.cs.sh;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//import tr.edu.itu.cs.hca.Museum;

//import tr.edu.itu.cs.hca.Museum;

public class IdiomListGeneratorJDBC {

    private Connection _db;

    public IdiomListGeneratorJDBC() {
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

    public Idiom getIdioms(String aName) {
        // List<Idiom> idioms = new LinkedList<Idiom>();
        Idiom idiom = new Idiom();
        try {

            String query = "SELECT id, name, year, location, desc FROM IDIOM WHERE(name = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, aName);
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                String pname = results.getString("name");
                Integer pyear = results.getInt("year");
                String plocation = results.getString("location");
                String pdesc = results.getString("desc");
                Integer pid = results.getInt("id");
                /*
                 * String pplace = results.getString("place"); String pidiom =
                 * results.getString("idiom");
                 */
                idiom.setId(pid);
                idiom.setName(pname);
                idiom.setDesc(pdesc);
                idiom.setLocation(plocation);
                idiom.setYear(pyear);
                // idioms.add(idiom);

                statement.close();
                results.close();
                return idiom;

            }

        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
        idiom = new Idiom();
        return idiom;
    }
}
