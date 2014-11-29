package tr.edu.itu.cs.ben;

import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Check;
import org.apache.wicket.markup.html.form.CheckGroup;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import tr.edu.itu.cs.db.WicketApplication;


public class PaintingStyleForm extends Form {
    private List<PaintingStyle> selectedPaintingStyles;

    public PaintingStyleForm(String id) {
        super(id);
        this.selectedPaintingStyles = new LinkedList<PaintingStyle>();
        CheckGroup paintingstyleCheckGroup = new CheckGroup(
                "selected_paintingstyles", this.selectedPaintingStyles);
        this.add(paintingstyleCheckGroup);

        WicketApplication app = (WicketApplication) this.getApplication();
        IPaintingStyleCollection collection = app.getPaintingStyleCollection();
        List<PaintingStyle> paintingstyles = collection.getPaintingStyles();

        PropertyListView paintingstyleListView = new PropertyListView(
                "paintingstyle_list", paintingstyles) {
            @Override
            protected void populateItem(ListItem item) {
                PaintingStyle paintingstyle = (PaintingStyle) item
                        .getModelObject();
                PaintingStyleDetailPageLink paintingstyleLink = new PaintingStyleDetailPageLink(
                        "paintingstyle_link", paintingstyle);
                paintingstyleLink.add(new Label("stylename"));
                item.add(new Check("selected", item.getModel()));
                item.add(paintingstyleLink);
            }
        };
        paintingstyleCheckGroup.add(paintingstyleListView);
    }

    @Override
    public void onSubmit() {
        WicketApplication app = (WicketApplication) this.getApplication();
        IPaintingStyleCollection collection = app.getPaintingStyleCollection();
        for (PaintingStyle paintingstyle : this.selectedPaintingStyles) {
            collection.deletePaintingStyle(paintingstyle);
        }
        this.setResponsePage(new PaintingStylePage());
    }
}
