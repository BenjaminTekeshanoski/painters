package tr.edu.itu.cs.ms;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import tr.edu.itu.cs.db.WicketApplication;


public class PmediaEditForm extends Form {
    private boolean newPmedia;

    public PmediaEditForm(String id, Pmedia aPmedia, boolean newPmediaFlag) {
        super(id);
        CompoundPropertyModel model = new CompoundPropertyModel(aPmedia);
        this.setModel(model);

        this.add(new TextField("name"));

        this.add(new TextField("desc"));

        this.newPmedia = newPmediaFlag;
    }

    @Override
    public void onSubmit() {
        Pmedia pmedia = (Pmedia) this.getModelObject();
        WicketApplication app = (WicketApplication) this.getApplication();
        IPmediaCollection collection = app.getPmediaCollection();

        if (this.newPmedia) {
            collection.addPmedia(pmedia);
        } else {
            collection.updatePmedia(pmedia);
        }
        this.setResponsePage(new PmediaDetailPage(pmedia));
    }
}
