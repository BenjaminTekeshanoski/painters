package tr.edu.itu.cs.ms;

import java.util.List;


public interface IPmediaCollection {
    public List<Pmedia> getPmedias();

    public void addPmedia(Pmedia aPmedia);

    public void deletePmedia(Pmedia aPmedia);

    public void updatePmedia(Pmedia aPmedia);
}
