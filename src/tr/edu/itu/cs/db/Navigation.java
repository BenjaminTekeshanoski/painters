package tr.edu.itu.cs.db;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;


public class Navigation extends Panel {
    public Navigation(String id) {
        super(id);
        Link homePageLink = new Link("home") {
            @Override
            public void onClick() {
                this.setResponsePage(new HomePage());
            }
        };
        this.add(homePageLink);

        Link paintingsPageLink = new Link("paintings") {
            @Override
            public void onClick() {
                this.setResponsePage(new PaintingsPage());
            }
        };
        this.add(paintingsPageLink);

        Link paintersPageLink = new Link("painters") {
            @Override
            public void onClick() {
                this.setResponsePage(new PaintersPage());
            }
        };
        this.add(paintersPageLink);

        Link trendsPageLink = new Link("idioms") {

            @Override
            public void onClick() {
                this.setResponsePage(new TrendsPage());
            }
        };
        this.add(trendsPageLink);

        Link contactPageLink = new Link("contact") {
            @Override
            public void onClick() {
                this.setResponsePage(new ContactPage());
            }
        };
        this.add(contactPageLink);
    }
}
