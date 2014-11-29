package tr.edu.itu.cs.ms;

import org.apache.wicket.markup.html.link.Link;


public class AwardDetailPageLink extends Link {
    private Award _award;

    public AwardDetailPageLink(String id, Award award) {
        super(id);
        this._award = award;
    }

    @Override
    public void onClick() {
        this.setResponsePage(new AwardDetailPage(this._award));
    }
}
