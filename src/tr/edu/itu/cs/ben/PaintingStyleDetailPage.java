package tr.edu.itu.cs.ben;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;


public final class PaintingStyleDetailPage extends BasePage {
    private PaintingStyle _paintingstyle;

    public PaintingStyleDetailPage(PaintingStyle aPaintingStyle) {
        this._paintingstyle = aPaintingStyle;

        this.add(new Label("name", aPaintingStyle.getName()));
        this.add(new Label("location", aPaintingStyle.getLocation()));
        this.add(new Label("year", Integer.toString(aPaintingStyle.getYear())));
        this.add(new Label("desc", aPaintingStyle.getDesc()));

        Link editLink = new Link("edit_link") {
            @Override
            public void onClick() {
                PaintingStyleDetailPage parent = (PaintingStyleDetailPage) this
                        .getParent();
                this.setResponsePage(new PaintingStyleEditPage(parent
                        .getPaintingStyle(), false));
            }
        };
        this.add(editLink);
    }

    public PaintingStyle getPaintingStyle() {
        return this._paintingstyle;
    }
}
