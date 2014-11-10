package tr.edu.itu.cs.hca;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import tr.edu.itu.cs.db.BasePage;
import tr.edu.itu.cs.db.WicketApplication;


public class MuseumPage extends BasePage {
    public MuseumPage() {
        WicketApplication app = (WicketApplication) this.getApplication();
        MuseumCollection collection = app.getCollection();
        List<Museum> museums = collection.getMuseums();

        PropertyListView museumListView = new PropertyListView("museum_list",
                museums) {
            @Override
            protected void populateItem(ListItem item) {
                item.add(new Label("name"));
                item.add(new Label("desc"));
                item.add(new Label("location"));
                item.add(new Label("year"));
            }
        };
        this.add(museumListView);
    }
}
