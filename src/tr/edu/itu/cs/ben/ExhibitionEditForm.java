package tr.edu.itu.cs.ben;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import tr.edu.itu.cs.db.WicketApplication;


public class ExhibitionEditForm extends Form {
    private boolean newExhibition;

    public ExhibitionEditForm(String id, Exhibition aExhibition,
            boolean newExhibitionFlag) {
        super(id);
        CompoundPropertyModel model = new CompoundPropertyModel(aExhibition);
        this.setModel(model);

        this.add(new TextField("name"));
        this.add(new TextField("year"));
        this.add(new TextField("location"));

        this.newExhibition = newExhibitionFlag;
    }

    @Override
    public void onSubmit() {
        Exhibition exhibition = (Exhibition) this.getModelObject();
        WicketApplication app = (WicketApplication) this.getApplication();
        IExhibitionCollection collection = app.getExhibitionCollection();

        if (this.newExhibition) {
            collection.addExhibition(exhibition);
        } else {
            collection.updateExhibition(exhibition);
        }
        this.setResponsePage(new ExhibitionDetailPage(exhibition));
    }
}
