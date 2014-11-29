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


public class PainterForm extends Form {
    private List<Painter> selectedPainters;

    public PainterForm(String id) {
        super(id);
        this.selectedPainters = new LinkedList<Painter>();
        CheckGroup painterCheckGroup = new CheckGroup("selected_painters",
                this.selectedPainters);
        this.add(painterCheckGroup);

        WicketApplication app = (WicketApplication) this.getApplication();
        IPainterCollection collection = app.getPainterCollection();
        List<Painter> painters = collection.getPainters();

        PropertyListView painterListView = new PropertyListView("painter_list",
                painters) {
            @Override
            protected void populateItem(ListItem item) {
                Painter painter = (Painter) item.getModelObject();
                PainterDetailPageLink painterLink = new PainterDetailPageLink(
                        "painter_link", painter);
                painterLink.add(new Label("name"));

                item.add(new Check("selected", item.getModel()));
                item.add(painterLink);
            }
        };
        painterCheckGroup.add(painterListView);
    }

    @Override
    public void onSubmit() {
        WicketApplication app = (WicketApplication) this.getApplication();
        IPainterCollection collection = app.getPainterCollection();
        for (Painter painter : this.selectedPainters) {
            collection.deletePainter(painter);
        }
        this.setResponsePage(new PainterPage());
    }
}
