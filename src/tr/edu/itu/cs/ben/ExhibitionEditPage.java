package tr.edu.itu.cs.ben;

import tr.edu.itu.cs.db.BasePage;


public final class ExhibitionEditPage extends BasePage {
    public ExhibitionEditPage(Exhibition aExhibition) {
        this.add(new ExhibitionEditForm("exhibition_edit", aExhibition, true));
    }

    public ExhibitionEditPage(Exhibition aExhibition, boolean newExhibitionFlag) {
        this.add(new ExhibitionEditForm("exhibition_edit", aExhibition,
                newExhibitionFlag));
    }
}
