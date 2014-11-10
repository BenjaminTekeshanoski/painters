package tr.edu.itu.cs.db;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import tr.edu.itu.cs.hca.MuseumPage;
import tr.edu.tr.cs.sh.TrendsPage;


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
                this.setResponsePage(new HomePage()); // buraya oluşturduğunuz
                                                      // paintings page i
                                                      // ekleyin
            }
        };
        this.add(paintingsPageLink);

        Link paintersPageLink = new Link("painters") {
            @Override
            public void onClick() {
                this.setResponsePage(new HomePage()); // buraya oluşturduğunuz
                                                      // painters page i ekleyin
            }
        };
        this.add(paintersPageLink);

        Link museumPageLink = new Link("museums") {
            @Override
            public void onClick() {
                this.setResponsePage(new MuseumPage());
            }
        };
        this.add(museumPageLink);

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
