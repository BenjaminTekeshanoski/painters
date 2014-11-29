package tr.edu.itu.cs.ben;

import org.apache.wicket.markup.html.link.Link;


public class PaintingStyleDetailPageLink extends Link {
    private PaintingStyle _paintingstyle;

    public PaintingStyleDetailPageLink(String id, PaintingStyle paintingstyle) {
        super(id);
        this._paintingstyle = paintingstyle;
    }

    @Override
    public void onClick() {
        this.setResponsePage(new PaintingStyleDetailPage(this._paintingstyle));
    }
}
