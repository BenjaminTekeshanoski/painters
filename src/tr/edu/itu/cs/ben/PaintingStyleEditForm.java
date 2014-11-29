package tr.edu.itu.cs.ben;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import tr.edu.itu.cs.db.WicketApplication;


public class PaintingStyleEditForm extends Form {
    private boolean newPaintingStyle;

    public PaintingStyleEditForm(String id, PaintingStyle aPaintingStyle,
            boolean newPaintingStyleFlag) {
        super(id);
        CompoundPropertyModel model = new CompoundPropertyModel(aPaintingStyle);
        this.setModel(model);

        this.add(new TextField("paintname"));
        this.add(new TextField("year"));
        this.add(new TextField("stylename"));
        this.add(new TextField("desc"));

        this.newPaintingStyle = newPaintingStyleFlag;
    }

    @Override
    public void onSubmit() {
        PaintingStyle paintingstyle = (PaintingStyle) this.getModelObject();
        WicketApplication app = (WicketApplication) this.getApplication();
        IPaintingStyleCollection collection = app.getPaintingStyleCollection();

        if (this.newPaintingStyle) {
            collection.addPaintingStyle(paintingstyle);
        } else {
            collection.updatePaintingStyle(paintingstyle);
        }
        this.setResponsePage(new PaintingStyleDetailPage(paintingstyle));
    }
}
