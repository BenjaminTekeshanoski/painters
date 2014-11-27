package tr.edu.tr.cs.sh;

import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;


public class PaintingPage extends BasePage {

    public PaintingPage() {
        Link paintingAddLink = new Link("add_painting") {
            @Override
            public void onClick() {
                Painting painting = new Painting("");
                this.setResponsePage(new PaintingEditPage(painting));
            }
        };
        this.add(paintingAddLink);

        PaintingForm paintingForm = new PaintingForm("painting_form");
        this.add(paintingForm);
    }
}
