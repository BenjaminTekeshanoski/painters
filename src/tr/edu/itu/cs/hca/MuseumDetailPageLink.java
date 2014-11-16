package tr.edu.itu.cs.hca;

import org.apache.wicket.markup.html.link.Link;


public class MuseumDetailPageLink extends Link {
    private Museum _museum;

    public MuseumDetailPageLink(String id, Museum museum) {
        super(id);
        this._museum = museum;
    }

    @Override
    public void onClick() {
        this.setResponsePage(new MuseumDetailPage(this._museum));
    }
}
