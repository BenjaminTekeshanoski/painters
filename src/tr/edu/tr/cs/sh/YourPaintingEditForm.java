package tr.edu.tr.cs.sh;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import tr.edu.itu.cs.db.WicketApplication;


public class YourPaintingEditForm extends Form {

    private boolean newYourPainting;

    public YourPaintingEditForm(String id, YourPainting aYourPainting,
            boolean newYourPaintingFlag) {
        super(id);
        CompoundPropertyModel model = new CompoundPropertyModel(aYourPainting);
        this.setModel(model);

        this.add(new TextField("name"));
        this.add(new TextField("year"));
        this.add(new TextField("location"));
        this.add(new TextField("desc"));

        this.newYourPainting = newYourPaintingFlag;
    }

    @Override
    public void onSubmit() {
        YourPainting yourPainting = (YourPainting) this.getModelObject();
        WicketApplication app = (WicketApplication) this.getApplication();
        IYourPaintingCollection collection = app.getYourPaintingCollection();

        if (this.newYourPainting) {
            collection.addYourPainting(yourPainting);
        } else {
            collection.updateYourPainting(yourPainting);
        }
        this.setResponsePage(new YourPaintingDetailPage(yourPainting));
    }
}
