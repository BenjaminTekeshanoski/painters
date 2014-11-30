package tr.edu.itu.cs.ben;

import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;
import tr.edu.itu.cs.users.User;


public class PaintingStylePage extends BasePage {
    public PaintingStylePage() {
        Link paintingstyleAddLink = new Link("add_paintingstyle") {
            @Override
            public void onClick() {
                PaintingStyle paintingstyle = new PaintingStyle("");
                this.setResponsePage(new PaintingStyleEditPage(paintingstyle));
            }
        };
        if (User.user.getAccesslevel() < 2)
            paintingstyleAddLink.setVisibilityAllowed(false);
        this.add(paintingstyleAddLink);

        PaintingStyleForm paintingstyleForm = new PaintingStyleForm(
                "paintingstyle_form");
        this.add(paintingstyleForm);
    }
}
