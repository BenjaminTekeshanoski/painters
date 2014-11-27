package tr.edu.tr.cs.sh;

import tr.edu.itu.cs.db.BasePage;
//import tr.edu.itu.cs.hca.Museum;
//import tr.edu.itu.cs.hca.MuseumEditForm;


public class PaintingEditPage-degistir extends BasePage {

    public PaintingEditPage(Painting aPainting) {
        this.add(new PaintingEditForm("painting_edit", aPainting, true));
    }

    public PaintingEditPage(Painting aPainting, boolean newPaintingFlag) {
        this.add(new PaintingEditForm("painting_edit", aPainting,
                newPaintingFlag));
    }
}
