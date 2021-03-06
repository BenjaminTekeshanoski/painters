package tr.edu.itu.cs.ms;

import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;
import tr.edu.itu.cs.users.User;


public class AwardPage extends BasePage {
    public AwardPage() {
        Link awardAddLink = new Link("add_award") {
            @Override
            public void onClick() {
                Award award = new Award("");
                this.setResponsePage(new AwardEditPage(award));
            }
        };
        if (User.user.getAccesslevel() < 2)
            awardAddLink.setVisibilityAllowed(false);
        this.add(awardAddLink);

        AwardForm awardForm = new AwardForm("award_form");
        this.add(awardForm);
    }
}
