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


public class AwardForm extends Form {
    private List<Award> selectedAwards;

    public AwardForm(String id) {
        super(id);
        this.selectedAwards = new LinkedList<Award>();
        CheckGroup awardCheckGroup = new CheckGroup("selected_awards",
                this.selectedAwards);
        this.add(awardCheckGroup);

        WicketApplication app = (WicketApplication) this.getApplication();
        IAwardCollection collection = app.getAwardCollection();
        List<Award> awards = collection.getAwards();

        PropertyListView awardListView = new PropertyListView("award_list",
                awards) {
            @Override
            protected void populateItem(ListItem item) {
                Award award = (Award) item.getModelObject();
                AwardDetailPageLink awardLink = new AwardDetailPageLink(
                        "award_link", award);
                awardLink.add(new Label("name"));
                item.add(new Check("selected", item.getModel()));
                item.add(awardLink);
            }
        };
        awardCheckGroup.add(awardListView);
    }

    @Override
    public void onSubmit() {
        WicketApplication app = (WicketApplication) this.getApplication();
        IAwardCollection collection = app.getAwardCollection();
        if (User.user.getAccesslevel() < 3) {
            this.setResponsePage(new ErrorPage());
        } else {
            for (Award award : this.selectedAwards) {
                collection.deleteAward(award);
            }
            this.setResponsePage(new AwardPage());
        }
    }
}
