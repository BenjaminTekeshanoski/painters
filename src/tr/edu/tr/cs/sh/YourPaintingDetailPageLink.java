package tr.edu.tr.cs.sh;

import org.apache.wicket.markup.html.link.Link;
//import tr.edu.itu.cs.hca.Museum;
//import tr.edu.itu.cs.hca.MuseumDetailPage;


public class YourPaintingDetailPageLink extends Link {

    private YourPainting _yourPainting;

    public YourPaintingDetailPageLink(String id, YourPainting yourPainting) {
        super(id);
        this._yourPainting = yourPainting;
    }

    @Override
    public void onClick() {
        this.setResponsePage(new YourPaintingDetailPage(this._yourPainting));
    }
}
