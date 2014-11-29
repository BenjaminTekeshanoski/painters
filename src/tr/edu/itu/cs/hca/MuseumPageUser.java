package tr.edu.itu.cs.hca;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import tr.edu.itu.cs.db.BasePage;
import tr.edu.itu.cs.db.WicketApplication;


public class MuseumPageUser extends BasePage {
    public MuseumPageUser() {

        WicketApplication app = (WicketApplication) this.getApplication();
        IMuseumCollection collection = app.getMuseumCollection();
        List<Museum> museums = collection.getMuseums();

        PropertyListView museumListView = new PropertyListView("museum_list",
                museums) {
            @Override
            protected void populateItem(ListItem item) {
                Museum museum = (Museum) item.getModelObject();
                MuseumDetailPageLink museumLink = new MuseumDetailPageLink(
                        "museum_link", museum);
                museumLink.add(new Label("name"));
                item.add(museumLink);
            }
        };
        this.add(museumListView);
    }
}
