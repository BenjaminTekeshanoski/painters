package tr.edu.itu.cs.ms;

import org.apache.wicket.markup.html.link.Link;


public class PmediaDetailPageLink extends Link {
    private Pmedia _pmedia;

    public PmediaDetailPageLink(String id, Pmedia pmedia) {
        super(id);
        this._pmedia = pmedia;
    }

    @Override
    public void onClick() {
        this.setResponsePage(new PmediaDetailPage(this._pmedia));
    }
}
