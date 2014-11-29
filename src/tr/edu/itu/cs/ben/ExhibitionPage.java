package tr.edu.itu.cs.ben;

import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;


public class ExhibitionPage extends BasePage {
    public ExhibitionPage() {
        Link exhibitionAddLink = new Link("add_exhibition") {
            @Override
            public void onClick() {
                Exhibition exhibition = new Exhibition("");
                this.setResponsePage(new ExhibitionEditPage(exhibition));
            }
        };
        this.add(exhibitionAddLink);

        ExhibitionForm exhibitionForm = new ExhibitionForm("exhibition_form");
        this.add(exhibitionForm);
    }
}
