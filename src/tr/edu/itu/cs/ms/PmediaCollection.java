package tr.edu.itu.cs.ms;

import java.util.LinkedList;
import java.util.List;


public class PmediaCollection implements IPmediaCollection {
    private List<Pmedia> pmedias;

    public PmediaCollection() {
        this.pmedias = new LinkedList<Pmedia>();
    }

    public List<Pmedia> getPmedias() {
        return this.pmedias;
    }

    public void addPmedia(Pmedia aPmedia) {
        this.pmedias.add(aPmedia);
    }

    public void deletePmedia(Pmedia aPmedia) {
        this.pmedias.remove(aPmedia);
    }

    public void updatePmedia(Pmedia aPmedia) {
    }
}
