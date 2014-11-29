package tr.edu.itu.cs.ms;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import tr.edu.itu.cs.db.BasePage;
import tr.edu.tr.cs.sh.Painting;
import tr.edu.tr.cs.sh.PaintingDetailPageLink;


public final class AwardDetailPage extends BasePage {
    private Award _award;

    public AwardDetailPage(Award aAward) {
        this._award = aAward;

        this.add(new Label("name", aAward.getName()));
        this.add(new Label("owner", aAward.getOwner()));
        this.add(new Label("year", aAward.getYear()));

        PaintingListGeneratorJDBC listgenerator = new PaintingListGeneratorJDBC();
        List<Painting> paintings = listgenerator
                .getPaintings(_award.getOwner());
        PropertyListView paintingListView = new PropertyListView(
                "painting_list", paintings) {
            @Override
            protected void populateItem(ListItem item) {
                Painting painting = (Painting) item.getModelObject();
                PaintingDetailPageLink paintingLink = new PaintingDetailPageLink(
                        "painting_link", painting);
                paintingLink.add(new Label("pname", painting.getName()));
                item.add(paintingLink);
            }
        };
        this.add(paintingListView);

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
