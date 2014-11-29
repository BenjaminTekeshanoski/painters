package tr.edu.itu.cs.ms;

import tr.edu.itu.cs.db.BasePage;


public final class AwardEditPage extends BasePage {
    public AwardEditPage(Award aAward) {
        this.add(new AwardEditForm("award_edit", aAward, true));
    }

    public AwardEditPage(Award aAward, boolean newAwardFlag) {
        this.add(new AwardEditForm("award_edit", aAward, newAwardFlag));
    }
}
