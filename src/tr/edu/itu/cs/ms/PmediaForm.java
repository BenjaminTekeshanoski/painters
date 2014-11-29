package tr.edu.itu.cs.ms;

import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Check;
import org.apache.wicket.markup.html.form.CheckGroup;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import tr.edu.itu.cs.db.WicketApplication;
import tr.edu.itu.cs.users.User;


public class PmediaForm extends Form {
    private List<Pmedia> selectedPmedias;

    public PmediaForm(String id) {
        super(id);
        this.selectedPmedias = new LinkedList<Pmedia>();
        CheckGroup pmediaCheckGroup = new CheckGroup("selected_pmedias",
                this.selectedPmedias);
        this.add(pmediaCheckGroup);

        WicketApplication app = (WicketApplication) this.getApplication();
        IPmediaCollection collection = app.getPmediaCollection();
        List<Pmedia> pmedias = collection.getPmedias();

        PropertyListView pmediaListView = new PropertyListView("pmedia_list",
                pmedias) {
            @Override
            protected void populateItem(ListItem item) {
                Pmedia pmedia = (Pmedia) item.getModelObject();
                PmediaDetailPageLink pmediaLink = new PmediaDetailPageLink(
                        "pmedia_link", pmedia);
                pmediaLink.add(new Label("name"));
                item.add(new Check("selected", item.getModel()));
                item.add(pmediaLink);
            }
        };
        pmediaCheckGroup.add(pmediaListView);
    }

    @Override
    public void onSubmit() {
        WicketApplication app = (WicketApplication) this.getApplication();
        IPmediaCollection collection = app.getPmediaCollection();
        if (User.user.getAccesslevel() < 3) {
            this.setResponsePage(new ErrorPage());
        } else {
            for (Pmedia pmedia : this.selectedPmedias) {
                collection.deletePmedia(pmedia);
            }
            this.setResponsePage(new PmediaPage());
        }
    }
}
