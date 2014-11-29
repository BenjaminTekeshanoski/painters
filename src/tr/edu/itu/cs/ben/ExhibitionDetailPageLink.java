package tr.edu.itu.cs.ben;

import org.apache.wicket.markup.html.link.Link;


public class ExhibitionDetailPageLink extends Link {
    private Exhibition _exhibition;

    public ExhibitionDetailPageLink(String id, Exhibition exhibition) {
        super(id);
        this._exhibition = exhibition;
    }

    @Override
    public void onClick() {
        this.setResponsePage(new ExhibitionDetailPage(this._exhibition));
    }
}
