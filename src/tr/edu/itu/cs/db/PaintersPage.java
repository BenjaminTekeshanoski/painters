package tr.edu.itu.cs.db;

import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.tr.TurkishPainters;


public class PaintersPage extends BasePage {
    public PaintersPage() {
        Link tpainters = new Link("tpainters") {
            @Override
            public void onClick() {
                this.setResponsePage(new TurkishPainters());
            }
        };
        this.add(tpainters);
    }
}
