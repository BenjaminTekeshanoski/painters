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


public class IdiomForm extends Form {

    private List<Idiom> selectedIdioms;

    public IdiomForm(String id) {
        super(id);
        this.selectedIdioms = new LinkedList<Idiom>();
        CheckGroup idiomCheckGroup = new CheckGroup("selected_idioms",
                this.selectedIdioms);
        this.add(idiomCheckGroup);

        WicketApplication app = (WicketApplication) this.getApplication();
        IIdiomCollection collection = app.getIdiomCollection();
        List<Idiom> idioms = collection.getIdioms();

        PropertyListView idiomListView = new PropertyListView("idiom_list",
                idioms) {
            @Override
            protected void populateItem(ListItem item) {
                Idiom idiom = (Idiom) item.getModelObject();
                IdiomDetailPageLink idiomLink = new IdiomDetailPageLink(
                        "idiom_link", idiom);
                idiomLink.add(new Label("name"));
                item.add(new Check("selected", item.getModel()));
                item.add(idiomLink);
            }
        };
        idiomCheckGroup.add(idiomListView);
    }

    @Override
    public void onSubmit() {
        WicketApplication app = (WicketApplication) this.getApplication();
        IIdiomCollection collection = app.getIdiomCollection();
        for (Idiom idiom : this.selectedIdioms) {
            collection.deleteIdiom(idiom);
        }
        this.setResponsePage(new IdiomPage());// new IdiomsPage());
                                              // degistir
        // geri al
    }
}
