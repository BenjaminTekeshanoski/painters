package tr.edu.tr.cs.sh;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.critic.Critic;
import tr.edu.itu.cs.db.BasePage;
import tr.edu.itu.cs.hca.Museum;
import tr.edu.itu.cs.hca.MuseumDetailPageLink;


public final class PaintingDetailPage extends BasePage {

    private Painting _painting;
    private Museum _museum;
    private Idiom _idiom;

    public PaintingDetailPage(Painting aPainting) {
        this._painting = aPainting;

        this.add(new Label("name", aPainting.getName()));
        this.add(new Label("year", Integer.toString(aPainting.getYear())));
        this.add(new Label("painter", aPainting.getPainter()));
        this.add(new Label("desc", aPainting.getDesc()));
        this.add(new Label("place", aPainting.getPlace()));
        this.add(new Label("idiom", aPainting.getIdiom()));

        MuseumListGeneratorJDBC listgenerator = new MuseumListGeneratorJDBC();
        this._museum = listgenerator.getMuseums(_painting.getPlace());

        MuseumDetailPageLink museumLink = new MuseumDetailPageLink(
                "museum_link", _museum);
        museumLink.add(new Label("pname", _museum.getName()));
        this.add(museumLink);

        IdiomListGeneratorJDBC listgenerators = new IdiomListGeneratorJDBC();
        this._idiom = listgenerators.getIdioms(_painting.getIdiom());

        IdiomDetailPageLink idiomLink = new IdiomDetailPageLink("idiom_link",
                _idiom);
        idiomLink.add(new Label("pnames", _idiom.getName()));
        this.add(idiomLink);

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

        Critic critic = new Critic(aPainting.getId());
        this.add(new Label("mesage", critic.getResult()));

    }

    public Painting getPainting() {
        return this._painting;
    }
}
