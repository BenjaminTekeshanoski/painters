package tr.edu.itu.cs.db;

import org.apache.wicket.protocol.http.WebApplication;

import tr.edu.itu.cs.hca.Museum;
import tr.edu.itu.cs.hca.MuseumCollection;


public class WicketApplication extends WebApplication {
    @Override
    public void init() {
        super.init();
    }

    @Override
    public Class<? extends BasePage> getHomePage() {
        return HomePage.class;
    }

    private MuseumCollection collection;

    public WicketApplication() {
        this.collection = new MuseumCollection();
        Museum museum1 = new Museum("Louvre Museum",
                "The world's most visited museum.", "Paris", 1973);
        collection.addMuseum(museum1);
        Museum museum2 = new Museum("Museum of Modern Art",
                "Most influential museum of modern art in the world.",
                "New York", 1929);
        collection.addMuseum(museum2);
    }

    public MuseumCollection getCollection() {
        return this.collection;
    }
}
