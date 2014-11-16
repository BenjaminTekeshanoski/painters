package tr.edu.itu.cs.hca;

import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;


public class MuseumPage extends BasePage {
    public MuseumPage() {
        Link museumAddLink = new Link("add_museum") {
            @Override
            public void onClick() {
                Museum museum = new Museum("");
                this.setResponsePage(new MuseumEditPage(museum));
            }
        };
        this.add(museumAddLink);

        MuseumForm museumForm = new MuseumForm("museum_form");
        this.add(museumForm);
    }
}
