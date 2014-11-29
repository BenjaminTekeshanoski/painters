package tr.edu.itu.cs.ben;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;


public final class ExhibitionDetailPage extends BasePage {
    private Exhibition _exhibition;

    public ExhibitionDetailPage(Exhibition aExhibition) {
        this._exhibition = aExhibition;

        this.add(new Label("name", aExhibition.getName()));
        this.add(new Label("location", aExhibition.getLocation()));
        this.add(new Label("year", Integer.toString(aExhibition.getYear())));
        this.add(new Label("desc", aExhibition.getDesc()));

        Link editLink = new Link("edit_link") {
            @Override
            public void onClick() {
                ExhibitionDetailPage parent = (ExhibitionDetailPage) this
                        .getParent();
                this.setResponsePage(new ExhibitionEditPage(parent
                        .getExhibition(), false));
            }
        };
        this.add(editLink);
    }

    public Exhibition getExhibition() {
        return this._exhibition;
    }
}
