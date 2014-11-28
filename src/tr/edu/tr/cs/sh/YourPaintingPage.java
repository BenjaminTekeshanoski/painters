package tr.edu.tr.cs.sh;

import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;


public class YourPaintingPage extends BasePage {

    public YourPaintingPage() {
        Link yourPaintingAddLink = new Link("add_yourPainting") {
            @Override
            public void onClick() {
                YourPainting yourPainting = new YourPainting("");
                this.setResponsePage(new YourPaintingEditPage(yourPainting));
            }
        };
        this.add(yourPaintingAddLink);

        YourPaintingForm yourPaintingForm = new YourPaintingForm(
                "yourPainting_form");
        this.add(yourPaintingForm);
    }
}
