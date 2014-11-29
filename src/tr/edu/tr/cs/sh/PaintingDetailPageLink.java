package tr.edu.tr.cs.sh;

import org.apache.wicket.markup.html.link.Link;


public class PaintingDetailPageLink extends Link {

    private Painting _painting;

    public PaintingDetailPageLink(String id, Painting painting) {
        super(id);
        this._painting = painting;
    }

    @Override
    public void onClick() {
        this.setResponsePage(new PaintingDetailPage(this._painting));
    }
}
