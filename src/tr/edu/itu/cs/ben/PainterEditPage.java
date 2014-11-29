package tr.edu.itu.cs.ben;

import tr.edu.itu.cs.db.BasePage;


public final class PainterEditPage extends BasePage {
    public PainterEditPage(Painter bPainter) {
        this.add(new PainterEditForm("painter_edit", bPainter, true));
    }

    public PainterEditPage(Painter bPainter, boolean newPainterFlag) {
        this.add(new PainterEditForm("painter_edit", bPainter, newPainterFlag));
    }
}
