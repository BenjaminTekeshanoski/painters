package tr.edu.itu.cs.ms;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import tr.edu.itu.cs.db.WicketApplication;


public class AwardEditForm extends Form {
    private boolean newAward;

    public AwardEditForm(String id, Award aAward, boolean newAwardFlag) {
        super(id);
        CompoundPropertyModel model = new CompoundPropertyModel(aAward);
        this.setModel(model);

        this.add(new TextField("name"));
        this.add(new TextField("owner"));
        this.add(new TextField("year"));

        this.newAward = newAwardFlag;
    }

    @Override
    public void onSubmit() {
        Award award = (Award) this.getModelObject();
        WicketApplication app = (WicketApplication) this.getApplication();
        IAwardCollection collection = app.getAwardCollection();

        if (this.newAward) {
            collection.addAward(award);
        } else {
            collection.updateAward(award);
        }
        this.setResponsePage(new AwardDetailPage(award));
    }
}
