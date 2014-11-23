package tr.edu.itu.cs.hca;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import tr.edu.itu.cs.db.BasePage;
import tr.edu.itu.cs.db.WicketApplication;


public class Updates extends BasePage {
    public Updates() {
        WicketApplication app = (WicketApplication) this.getApplication();
        IUpdateCollection collection = app.getUpdateCollection();
        List<Update> updates = collection.getUpdates();

        PropertyListView updateListView = new PropertyListView("update_list",
                updates) {
            @Override
            protected void populateItem(ListItem item) {
                item.add(new Label("desc"));
            }
        };
        this.add(updateListView);
    }
}
