package tr.edu.itu.cs.ben;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import tr.edu.itu.cs.db.WicketApplication;


public class PainterEditForm extends Form {
    private boolean newPainter;

    public PainterEditForm(String id, Painter aPainter, boolean newPainterFlag) {
        super(id);
        CompoundPropertyModel model = new CompoundPropertyModel(aPainter);
        this.setModel(model);

        this.add(new TextField("name"));
        this.add(new TextField("age"));
        this.add(new TextField("country"));
        this.add(new TextField("biography"));
        this.add(new TextField("comment"));
        this.add(new TextField("award"));
        this.add(new TextField("idiom"));

        this.newPainter = newPainterFlag;
    }

    @Override
    public void onSubmit() {
        Painter painter = (Painter) this.getModelObject();
        WicketApplication app = (WicketApplication) this.getApplication();
        IPainterCollection collection = app.getPainterCollection();

        if (this.newPainter) {
            collection.addPainter(painter);
        } else {
            collection.updatePainter(painter);
        }
        this.setResponsePage(new PainterDetailPage(painter));
    }
}
