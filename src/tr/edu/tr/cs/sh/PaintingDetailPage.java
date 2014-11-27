package tr.edu.tr.cs.sh;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;


public final class PaintingDetailPage extends BasePage {

    private Painting _painting;

    public PaintingDetailPage(Painting aPainting) {
        this._painting = aPainting;

        this.add(new Label("name", aPainting.getName()));
        this.add(new Label("year", Integer.toString(aPainting.getYear())));
        this.add(new Label("location", aPainting.getLocation()));

        this.add(new Label("desc", aPainting.getDesc()));

        Link editLink = new Link("edit_link") {
            @Override
            public void onClick() {
                PaintingDetailPage parent = (PaintingDetailPage) this
                        .getParent();
                this.setResponsePage(new PaintingEditPage(parent.getPainting(),
                        false));
            }
        };
        this.add(editLink);
    }

    public Painting getPainting() {
        return this._painting;
    }
}
