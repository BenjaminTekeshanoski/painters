package tr.edu.itu.cs.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;

import org.apache.wicket.protocol.http.WebApplication;

import tr.edu.itu.cs.hca.IMuseumCollection;
import tr.edu.itu.cs.hca.MuseumCollectionJDBC;


public class WicketApplication extends WebApplication {
    private Connection _conn;
    private IMuseumCollection _collection;

    @Override
    public void init() {
        super.init();
        this.initializeDb();
        this.createDB();
        this._collection = new MuseumCollectionJDBC();
    }

    @Override
    public Class<? extends BasePage> getHomePage() {
        return HomePage.class;
    }

    private void initializeDb() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }

        try {
            String sqlite = "jdbc:sqlite:";
            String home = System.getProperty("user.home");
            String jdbcURL = sqlite + home + File.separator + "painters.sqlite";
            this._conn = DriverManager.getConnection(jdbcURL);
        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
    }

    public void createDB() {
        String line = "";
        ServletContext context = getServletContext();
        InputStream stream = context.getResourceAsStream("/WEB-INF/init.sql");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(stream));

        try {
            while ((line = reader.readLine()) != null) {
                Statement stmt = _conn.createStatement();
                stmt.executeUpdate(line);
            }
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        } catch (IOException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public IMuseumCollection getCollection() {
        return this._collection;
    }

}
