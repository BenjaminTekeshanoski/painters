package tr.edu.itu.cs.ms;

import java.util.List;


public interface IAwardCollection {
    public List<Award> getAwards();

    public void addAward(Award aAward);

    public void deleteAward(Award aAward);

    public void updateAward(Award aAward);
}
