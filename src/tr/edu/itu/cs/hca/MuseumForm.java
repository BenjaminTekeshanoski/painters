package tr.edu.itu.cs.hca;

import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Check;
import org.apache.wicket.markup.html.form.CheckGroup;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import tr.edu.itu.cs.db.WicketApplication;


public class MuseumForm extends Form {
    private List<Museum> selectedMuseums;

    public MuseumForm(String id) {
        super(id);
        this.selectedMuseums = new LinkedList<Museum>();
        CheckGroup museumCheckGroup = new CheckGroup("selected_museums",
                this.selectedMuseums);
        this.add(museumCheckGroup);

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
                item.add(new Check("selected", item.getModel()));
                item.add(museumLink);
            }
        };
        museumCheckGroup.add(museumListView);
    }

    @Override
    public void onSubmit() {
        WicketApplication app = (WicketApplication) this.getApplication();
        IMuseumCollection collection = app.getMuseumCollection();
        for (Museum museum : this.selectedMuseums) {
            collection.deleteMuseum(museum);
        }
        this.setResponsePage(new MuseumPage());
    }
}
