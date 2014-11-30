package tr.edu.itu.cs.ben;

import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;
import tr.edu.itu.cs.users.User;


public class PainterPage extends BasePage {
    public PainterPage() {

        Link painterAddLink = new Link("add_painter") {
            @Override
            public void onClick() {
                Painter painter = new Painter("");
                this.setResponsePage(new PainterEditPage(painter));
            }
        };
        if (User.user.getAccesslevel() < 2)
            painterAddLink.setVisibilityAllowed(false);
        this.add(painterAddLink);

        PainterForm painterForm = new PainterForm("painter_form");
        this.add(painterForm);

    }
}
