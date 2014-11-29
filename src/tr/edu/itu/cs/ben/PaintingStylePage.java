package tr.edu.itu.cs.ben;

import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;


public class PaintingStylePage extends BasePage {
    public PaintingStylePage() {
        Link paintingstyleAddLink = new Link("add_paintingstyle") {
            @Override
            public void onClick() {
                PaintingStyle paintingstyle = new PaintingStyle("");
                this.setResponsePage(new PaintingStyleEditPage(paintingstyle));
            }
        };
        this.add(paintingstyleAddLink);

        PaintingStyleForm paintingstyleForm = new PaintingStyleForm(
                "paintingstyle_form");
        this.add(paintingstyleForm);
    }
}
