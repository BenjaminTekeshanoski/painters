package tr.edu.itu.cs.hca;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import tr.edu.itu.cs.db.WicketApplication;
import tr.edu.itu.cs.users.User;


public class MuseumEditForm extends Form {
    private boolean newMuseum;

    public MuseumEditForm(String id, Museum aMuseum, boolean newMuseumFlag) {
        super(id);
        CompoundPropertyModel model = new CompoundPropertyModel(aMuseum);
        this.setModel(model);

        this.add(new TextField("name"));
        this.add(new TextField("year"));
        this.add(new TextField("location"));
        this.add(new TextField("desc"));

        this.newMuseum = newMuseumFlag;
    }

    @Override
    public void onSubmit() {
        Museum museum = (Museum) this.getModelObject();
        WicketApplication app = (WicketApplication) this.getApplication();
        IMuseumCollection collection = app.getMuseumCollection();

        if (this.newMuseum) {
            collection.addMuseum(museum);
        } else {
            collection.updateMuseum(museum);
        }
        if (User.user.getAccesslevel() < 3) {
            this.setResponsePage(new MuseumDetailPageUser(museum));
        } else {
            this.setResponsePage(new MuseumDetailPage(museum));
        }
    }
}
