package tr.edu.itu.cs.db;

import org.apache.wicket.protocol.http.WebApplication;


public class WicketApplication extends WebApplication {
    @Override
    public void init() {
        super.init();
    }

    @Override
    public Class<? extends BasePage> getHomePage() {
        return HomePage.class;
    }
}
