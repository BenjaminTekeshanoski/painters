package tr.edu.itu.cs.hca;

import tr.edu.itu.cs.db.BasePage;


public final class MuseumEditPage extends BasePage {
    public MuseumEditPage(Museum aMuseum) {
        this.add(new MuseumEditForm("museum_edit", aMuseum, true));
    }

    public MuseumEditPage(Museum aMuseum, boolean newMuseumFlag) {
        this.add(new MuseumEditForm("museum_edit", aMuseum, newMuseumFlag));
    }
}
