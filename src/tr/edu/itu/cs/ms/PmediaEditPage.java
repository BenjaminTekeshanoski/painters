package tr.edu.itu.cs.ms;

import tr.edu.itu.cs.db.BasePage;


public final class PmediaEditPage extends BasePage {
    public PmediaEditPage(Pmedia aComment) {
        this.add(new PmediaEditForm("pmedia_edit", aComment, true));
    }

    public PmediaEditPage(Pmedia aComment, boolean newPmediaFlag) {
        this.add(new PmediaEditForm("pmedia_edit", aComment, newPmediaFlag));
    }
}
