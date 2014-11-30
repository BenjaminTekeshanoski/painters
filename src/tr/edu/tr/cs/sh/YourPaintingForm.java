package tr.edu.tr.cs.sh;

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


public class YourPaintingForm extends Form {

    private List<YourPainting> selectedYourPaintings;

    public YourPaintingForm(String id) {
        super(id);
        this.selectedYourPaintings = new LinkedList<YourPainting>();
        CheckGroup yourPaintingCheckGroup = new CheckGroup(
                "selected_yourPaintings", this.selectedYourPaintings);
        this.add(yourPaintingCheckGroup);

        WicketApplication app = (WicketApplication) this.getApplication();
        IYourPaintingCollection collection = app.getYourPaintingCollection();
        List<YourPainting> yourPaintings = collection.getYourPaintings();

        PropertyListView yourPaintingListView = new PropertyListView(
                "yourPainting_list", yourPaintings) {
            @Override
            protected void populateItem(ListItem item) {
                YourPainting yourPainting = (YourPainting) item
                        .getModelObject();
                YourPaintingDetailPageLink yourPaintingLink = new YourPaintingDetailPageLink(
                        "yourPainting_link", yourPainting);
                yourPaintingLink.add(new Label("name"));
                item.add(new Check("selected", item.getModel()));
                item.add(yourPaintingLink);
            }
        };

        yourPaintingCheckGroup.add(yourPaintingListView);
    }

    @Override
    public void onSubmit() {
        WicketApplication app = (WicketApplication) this.getApplication();
        IYourPaintingCollection collection = app.getYourPaintingCollection();
        if (User.user.getAccesslevel() == 3) {
            for (YourPainting yourPainting : this.selectedYourPaintings) {
                collection.deleteYourPainting(yourPainting);
            }
            this.setResponsePage(new YourPaintingPage());// new
        } else {
            this.setResponsePage(new ErrorPage());
        } // YourPaintingsPage());
        // degistir
        // geri al
    }
}
