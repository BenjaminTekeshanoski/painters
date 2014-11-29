package tr.edu.itu.cs.ben;

import tr.edu.itu.cs.db.BasePage;


public final class PaintingStyleEditPage extends BasePage {
    public PaintingStyleEditPage(PaintingStyle aPaintingStyle) {
        this.add(new PaintingStyleEditForm("paintingstyle_edit",
                aPaintingStyle, true));
    }

    public PaintingStyleEditPage(PaintingStyle aPaintingStyle,
            boolean newPaintingStyleFlag) {
        this.add(new PaintingStyleEditForm("paintingstyle_edit",
                aPaintingStyle, newPaintingStyleFlag));
    }
}
