package tr.edu.itu.cs.ben;

import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;
import tr.edu.itu.cs.users.User;


public class ExhibitionPage extends BasePage {
    public ExhibitionPage() {
        Link exhibitionAddLink = new Link("add_exhibition") {
            @Override
            public void onClick() {
                Exhibition exhibition = new Exhibition("");
                this.setResponsePage(new ExhibitionEditPage(exhibition));
            }
        };
        if (User.user.getAccesslevel() < 2)
            exhibitionAddLink.setVisibilityAllowed(false);
        this.add(exhibitionAddLink);

        ExhibitionForm exhibitionForm = new ExhibitionForm("exhibition_form");
        this.add(exhibitionForm);
    }
}
