package tr.edu.itu.cs.ms;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;


public final class AwardDetailPage extends BasePage {
    private Award _award;

    public AwardDetailPage(Award aAward) {
        this._award = aAward;

        this.add(new Label("name", aAward.getName()));
        this.add(new Label("owner", aAward.getOwner()));
        this.add(new Label("year", Integer.toString(aAward.getYear())));

        Link editLink = new Link("edit_link") {
            @Override
            public void onClick() {
                AwardDetailPage parent = (AwardDetailPage) this.getParent();
                this.setResponsePage(new AwardEditPage(parent.getAward(), false));
            }
        };
        this.add(editLink);
    }

    public Award getAward() {
        return this._award;
    }
}
