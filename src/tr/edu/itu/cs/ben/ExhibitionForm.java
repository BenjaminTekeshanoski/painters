package tr.edu.itu.cs.ben;

import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Check;
import org.apache.wicket.markup.html.form.CheckGroup;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import tr.edu.itu.cs.db.WicketApplication;
import tr.edu.itu.cs.ms.ErrorPage;
import tr.edu.itu.cs.users.User;


public class ExhibitionForm extends Form {
    private List<Exhibition> selectedExhibitions;

    public ExhibitionForm(String id) {
        super(id);
        this.selectedExhibitions = new LinkedList<Exhibition>();
        CheckGroup exhibitionCheckGroup = new CheckGroup(
                "selected_exhibitions", this.selectedExhibitions);
        this.add(exhibitionCheckGroup);

        WicketApplication app = (WicketApplication) this.getApplication();
        IExhibitionCollection collection = app.getExhibitionCollection();
        List<Exhibition> exhibitions = collection.getExhibitions();

        PropertyListView exhibitionListView = new PropertyListView(
                "exhibition_list", exhibitions) {
            @Override
            protected void populateItem(ListItem item) {
                Exhibition exhibition = (Exhibition) item.getModelObject();
                ExhibitionDetailPageLink exhibitionLink = new ExhibitionDetailPageLink(
                        "exhibition_link", exhibition);
                exhibitionLink.add(new Label("name"));
                item.add(new Check("selected", item.getModel()));
                item.add(exhibitionLink);
            }
        };
        exhibitionCheckGroup.add(exhibitionListView);
    }

    @Override
    public void onSubmit() {
        WicketApplication app = (WicketApplication) this.getApplication();
        IExhibitionCollection collection = app.getExhibitionCollection();
        if (User.user.getAccesslevel() < 3) {
            this.setResponsePage(new ErrorPage());
        } else {
            for (Exhibition exhibition : this.selectedExhibitions) {
                collection.deleteExhibition(exhibition);
            }
            this.setResponsePage(new ExhibitionPage());
        }
    }
}
