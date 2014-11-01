package tr.edu.itu.cs.db;

import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.tr.TurkishPaintings;

public class PaintingsPage extends BasePage {
    public PaintingsPage() {
        Link tpaintings = new Link("tpaintings") {
            @Override
            public void onClick() {
                this.setResponsePage(new TurkishPaintings());
            }
        };
        this.add(tpaintings);
    }
}
