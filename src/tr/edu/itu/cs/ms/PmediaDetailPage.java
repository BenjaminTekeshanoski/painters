package tr.edu.itu.cs.ms;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;


public final class PmediaDetailPage extends BasePage {
    private Pmedia _pmedia;

    public PmediaDetailPage(Pmedia aPmedia) {
        this._pmedia = aPmedia;

        this.add(new Label("name", aPmedia.getName()));
        this.add(new Label("desc", aPmedia.getDesc()));

        Link editLink = new Link("edit_link") {
            @Override
            public void onClick() {
                PmediaDetailPage parent = (PmediaDetailPage) this.getParent();
                this.setResponsePage(new PmediaEditPage(parent.getPmedia(),
                        false));
            }
        };
        this.add(editLink);
    }

    public Pmedia getPmedia() {
        return this._pmedia;
    }
}
