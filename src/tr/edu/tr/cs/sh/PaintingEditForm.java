package tr.edu.tr.cs.sh;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import tr.edu.itu.cs.db.WicketApplication;
import tr.edu.itu.cs.users.User;


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
        // degistirebilir yani bu kod
        // calisir
        Painting painting = (Painting) this.getModelObject();
        WicketApplication app = (WicketApplication) this.getApplication();
        IPaintingCollection collection = app.getPaintingCollection();

        if (User.user.getAccesslevel() < 3) { // / Gokayin kodu eger adminse

            this.setResponsePage(new ErrorPage());

        } else {
            if (this.newPainting) {
                collection.addPainting(painting);
            } else {
                collection.updatePainting(painting);
            }
            if (painting.getId() != null) {
                this.setResponsePage(new PaintingDetailPage(painting));
            } else {
                this.setResponsePage(new PaintingPage());
            }
        }

    }
}
