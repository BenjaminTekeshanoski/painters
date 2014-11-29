package tr.edu.tr.cs.sh;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import tr.edu.itu.cs.db.WicketApplication;


public class PaintingEditForm extends Form {

    private boolean newPainting;

    public PaintingEditForm(String id, Painting aPainting,
            boolean newPaintingFlag) {
        super(id);
        CompoundPropertyModel model = new CompoundPropertyModel(aPainting);
        this.setModel(model);

        this.add(new TextField("name"));
        this.add(new TextField("year"));
        this.add(new TextField("painter"));
        this.add(new TextField("desc"));
        this.add(new TextField("place"));
        this.add(new TextField("idiom"));

        this.newPainting = newPaintingFlag;
    }

    @Override
    public void onSubmit() {
        Painting painting = (Painting) this.getModelObject();
        WicketApplication app = (WicketApplication) this.getApplication();
        IPaintingCollection collection = app.getPaintingCollection();

        if (this.newPainting) {
            collection.addPainting(painting);
        } else {
            collection.updatePainting(painting);
        }
        this.setResponsePage(new PaintingDetailPage(painting));
    }
}
