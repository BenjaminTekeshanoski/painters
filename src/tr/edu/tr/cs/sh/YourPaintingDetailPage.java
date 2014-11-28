package tr.edu.tr.cs.sh;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;


public final class YourPaintingDetailPage extends BasePage {

    private YourPainting _yourPainting;

    public YourPaintingDetailPage(YourPainting aYourPainting) {
        this._yourPainting = aYourPainting;

        this.add(new Label("name", aYourPainting.getName()));
        this.add(new Label("year", Integer.toString(aYourPainting.getYear())));
        this.add(new Label("location", aYourPainting.getLocation()));

        this.add(new Label("desc", aYourPainting.getDesc()));

        Link editLink = new Link("edit_link") {
            @Override
            public void onClick() {
                YourPaintingDetailPage parent = (YourPaintingDetailPage) this
                        .getParent();
                this.setResponsePage(new YourPaintingEditPage(parent
                        .getYourPainting(), false));
            }
        };
        this.add(editLink);
    }

    public YourPainting getYourPainting() {
        return this._yourPainting;
    }
}
