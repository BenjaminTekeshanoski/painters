package tr.edu.tr.cs.sh;

import org.apache.wicket.markup.html.link.Link;
//import tr.edu.itu.cs.hca.Museum;
//import tr.edu.itu.cs.hca.MuseumDetailPage;

import tr.edu.tr.cs.sh.Painting;
import tr.edu.tr.cs.sh.PaintingDetailPage;


public class PaintingDetailPageLink-degistir extends Link {

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
