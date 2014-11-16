package tr.edu.itu.cs.hca;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;


public final class MuseumDetailPage extends BasePage {
    private Museum _museum;

    public MuseumDetailPage(Museum aMuseum) {
        this._museum = aMuseum;

        this.add(new Label("name", aMuseum.getName()));
        this.add(new Label("location", aMuseum.getLocation()));
        this.add(new Label("year", Integer.toString(aMuseum.getYear())));
        this.add(new Label("desc", aMuseum.getDesc()));

        Link editLink = new Link("edit_link") {
            @Override
            public void onClick() {
                MuseumDetailPage parent = (MuseumDetailPage) this.getParent();
                this.setResponsePage(new MuseumEditPage(parent.getMuseum(),
                        false));
            }
        };
        this.add(editLink);
    }

    public Museum getMuseum() {
        return this._museum;
    }
}
