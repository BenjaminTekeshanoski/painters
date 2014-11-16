package tr.edu.itu.cs.db;

import org.apache.wicket.protocol.http.WebApplication;

import tr.edu.itu.cs.hca.IMuseumCollection;
import tr.edu.itu.cs.hca.MuseumCollectionJDBC;


public class WicketApplication extends WebApplication {
    private IMuseumCollection _collection;

    @Override
    public void init() {
        super.init();
        this._collection = new MuseumCollectionJDBC(
                "C:/Users/HasanCan/Documents/itucsdb.sqlite");
    }

    @Override
    public Class<? extends BasePage> getHomePage() {
        return HomePage.class;
    }

    /*
     * public WicketApplication() { this.collection = new MuseumCollection();
     * Museum museum1 = new Museum("Louvre Museum",
     * "The world's most visited museum.", "Paris", 1973);
     * collection.addMuseum(museum1); Museum museum2 = new
     * Museum("Museum of Modern Art",
     * "Most influential museum of modern art in the world.", "New York", 1929);
     * collection.addMuseum(museum2); }
     */

    public IMuseumCollection getCollection() {
        return this._collection;
    }

}
