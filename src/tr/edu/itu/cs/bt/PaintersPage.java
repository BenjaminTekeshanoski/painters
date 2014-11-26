package tr.edu.itu.cs.bt;

/*public class PaintersPage {

 }*/
import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;


public class PaintersPage extends BasePage {
    public PaintersPage() {
        Link museumAddLink = new Link("add_museum") {
            @Override
            public void onClick() {
                Painters painters = new Painters("");
                this.setResponsePage(new PaintersPage());
            }
        };
        this.add(museumAddLink);

        /*
         * MuseumForm museumForm = new MuseumForm("museum_form");
         * this.add(museumForm);
         */
    }
}
