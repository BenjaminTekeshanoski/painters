package tr.edu.itu.cs.ben;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;


public final class PainterDetailPage extends BasePage {
    private Painter _painter;

    public PainterDetailPage(Painter aPainter) {
        this._painter = aPainter;

        this.add(new Label("name", aPainter.getName()));
        this.add(new Label("location", aPainter.getLocation()));
        this.add(new Label("year", Integer.toString(aPainter.getYear())));
        this.add(new Label("desc", aPainter.getDesc()));

        Link editLink = new Link("edit_link") {
            @Override
            public void onClick() {
                PainterDetailPage parent = (PainterDetailPage) this.getParent();
                this.setResponsePage(new PainterEditPage(parent.getPainter(),
                        false));
            }
        };
        this.add(editLink);
    }

    public Painter getPainter() {
        return this._painter;
    }
}
