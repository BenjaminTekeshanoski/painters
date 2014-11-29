package tr.edu.itu.cs.ms;

import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;
import tr.edu.itu.cs.users.User;


public class PmediaPage extends BasePage {
    public PmediaPage() {
        Link pmediaAddLink = new Link("add_pmedia") {
            @Override
            public void onClick() {
                Pmedia pmedia = new Pmedia("");
                this.setResponsePage(new PmediaEditPage(pmedia));
            }
        };
        if (User.user.getAccesslevel() < 2)
            pmediaAddLink.setVisibilityAllowed(false);
        this.add(pmediaAddLink);

        PmediaForm pmediaForm = new PmediaForm("pmedia_form");
        this.add(pmediaForm);
    }
}
