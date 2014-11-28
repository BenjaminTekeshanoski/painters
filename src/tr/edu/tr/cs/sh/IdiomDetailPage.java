package tr.edu.tr.cs.sh;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;


public final class IdiomDetailPage extends BasePage {

    private Idiom _idiom;

    public IdiomDetailPage(Idiom aIdiom) {
        this._idiom = aIdiom;

        this.add(new Label("name", aIdiom.getName()));
        this.add(new Label("year", Integer.toString(aIdiom.getYear())));
        this.add(new Label("location", aIdiom.getLocation()));

        this.add(new Label("desc", aIdiom.getDesc()));

        Link editLink = new Link("edit_link") {
            @Override
            public void onClick() {
                IdiomDetailPage parent = (IdiomDetailPage) this.getParent();
                this.setResponsePage(new IdiomEditPage(parent.getIdiom(), false));
            }
        };
        this.add(editLink);
    }

    public Idiom getIdiom() {
        return this._idiom;
    }
}
