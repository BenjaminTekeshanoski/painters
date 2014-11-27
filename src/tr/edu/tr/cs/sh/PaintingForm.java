package tr.edu.tr.cs.sh;

import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Check;
import org.apache.wicket.markup.html.form.CheckGroup;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import tr.edu.itu.cs.db.WicketApplication;


public class PaintingForm extends Form {

    private List<Painting> selectedPaintings;

    public PaintingForm(String id) {
        super(id);
        this.selectedPaintings = new LinkedList<Painting>();
        CheckGroup paintingCheckGroup = new CheckGroup("selected_paintings",
                this.selectedPaintings);
        this.add(paintingCheckGroup);

        WicketApplication app = (WicketApplication) this.getApplication();
        IPaintingCollection collection = app.getPaintingCollection();
        List<Painting> paintings = collection.getPaintings();

        PropertyListView paintingListView = new PropertyListView(
                "painting_list", paintings) {
            @Override
            protected void populateItem(ListItem item) {
                Painting painting = (Painting) item.getModelObject();
                PaintingDetailPageLink paintingLink = new PaintingDetailPageLink(
                        "painting_link", painting);
                paintingLink.add(new Label("name"));
                item.add(new Check("selected", item.getModel()));
                item.add(paintingLink);
            }
        };
        paintingCheckGroup.add(paintingListView);
    }

    @Override
    public void onSubmit() {
        WicketApplication app = (WicketApplication) this.getApplication();
        IPaintingCollection collection = app.getPaintingCollection();
        for (Painting painting : this.selectedPaintings) {
            collection.deletePainting(painting);
        }
        this.setResponsePage(new PaintingPage());// new PaintingsPage());
                                                 // degistir
        // geri al
    }
}
