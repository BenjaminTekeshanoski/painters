package tr.edu.itu.cs.ms;

import java.util.LinkedList;
import java.util.List;


public class AwardCollection implements IAwardCollection {
    private List<Award> awards;

    public AwardCollection() {
        this.awards = new LinkedList<Award>();
    }

    public List<Award> getAwards() {
        return this.awards;
    }

    public void addAward(Award aAward) {
        this.awards.add(aAward);
    }

    public void deleteAward(Award aAward) {
        this.awards.remove(aAward);
    }

    public void updateAward(Award aAward) {
    }
}
