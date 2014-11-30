package tr.edu.tr.cs.sh;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import tr.edu.itu.cs.db.WicketApplication;
import tr.edu.itu.cs.users.User;


public class IdiomEditForm extends Form {

    private boolean newIdiom;

    public IdiomEditForm(String id, Idiom aIdiom, boolean newIdiomFlag) {
        super(id);
        CompoundPropertyModel model = new CompoundPropertyModel(aIdiom);
        this.setModel(model);

        this.add(new TextField("name"));
        this.add(new TextField("year"));
        this.add(new TextField("location"));
        this.add(new TextField("desc"));

        this.newIdiom = newIdiomFlag;
    }

    @Override
    public void onSubmit() {
        Idiom idiom = (Idiom) this.getModelObject();
        WicketApplication app = (WicketApplication) this.getApplication();
        IIdiomCollection collection = app.getIdiomCollection();
        if (User.user.getAccesslevel() == 3) {

            if (this.newIdiom) {
                collection.addIdiom(idiom);
            } else {
                collection.updateIdiom(idiom);
            }
            this.setResponsePage(new IdiomDetailPage(idiom));
        } else {
            this.setResponsePage(new ErrorPage());
        }

    }
}
