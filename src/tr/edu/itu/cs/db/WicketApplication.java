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

import tr.edu.itu.cs.hca.ILocationCollection;
import tr.edu.itu.cs.hca.IMuseumCollection;
import tr.edu.itu.cs.hca.IUpdateCollection;
import tr.edu.itu.cs.hca.LocationCollectionJDBC;
import tr.edu.itu.cs.hca.MuseumCollectionJDBC;
import tr.edu.itu.cs.hca.UpdateCollectionJDBC;
import tr.edu.itu.cs.ms.CommentCollectionJDBC;
import tr.edu.itu.cs.ms.ICommentCollection;
import tr.edu.tr.cs.sh.IIdiomCollection;
//Shuaib//
import tr.edu.tr.cs.sh.IPaintingCollection;
import tr.edu.tr.cs.sh.IYourPaintingCollection;
import tr.edu.tr.cs.sh.IdiomCollectionJDBC;
import tr.edu.tr.cs.sh.PaintingCollectionJDBC;
import tr.edu.tr.cs.sh.YourPaintingCollectionJDBC;


public class WicketApplication extends WebApplication {
    private Connection _conn;
    private IMuseumCollection _museum_collection;
    private IUpdateCollection _update_collection;
    private ILocationCollection _location_collection;
    private ICommentCollection _comment_collection;

    // Shuaib//
    private IPaintingCollection _painting_collection;
    private IIdiomCollection _idiom_collection;
    private IYourPaintingCollection _yourpainting_collection;

    @Override
    public void init() {
        super.init();
        this.initializeDb();
        this.createDB();
        this._museum_collection = new MuseumCollectionJDBC();
        this._update_collection = new UpdateCollectionJDBC();
        this._location_collection = new LocationCollectionJDBC();
        this._comment_collection = new CommentCollectionJDBC();
        // Shuaib//
        this._painting_collection = new PaintingCollectionJDBC();
        this._idiom_collection = new IdiomCollectionJDBC();
        this._yourpainting_collection = new YourPaintingCollectionJDBC();
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

    public IMuseumCollection getMuseumCollection() {
        return this._museum_collection;
    }

    public IUpdateCollection getUpdateCollection() {
        return this._update_collection;
    }

    public ILocationCollection getLocationCollection() {
        return this._location_collection;
    }

    public ICommentCollection getCollection() {
        return this._comment_collection;
    }

    // Shuaib//
    public IPaintingCollection getPaintingCollection() {
        return this._painting_collection;

    }

    public IIdiomCollection getIdiomCollection() {
        return this._idiom_collection;
    }

    public IYourPaintingCollection getYourPaintingCollection() {
        return this._yourpainting_collection;

    }

}
