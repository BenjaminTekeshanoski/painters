package tr.edu.itu.cs.ben;

import org.apache.wicket.markup.html.link.Link;


public class PainterDetailPageLink extends Link {
    private Painter _painter;

    public PainterDetailPageLink(String id, Painter painter) {
        super(id);
        this._painter = painter;
    }

    @Override
    public void onClick() {
        this.setResponsePage(new PainterDetailPage(this._painter));
    }
}
