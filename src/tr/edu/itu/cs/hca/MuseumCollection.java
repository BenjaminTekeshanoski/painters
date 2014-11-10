package tr.edu.itu.cs.hca;

import java.util.LinkedList;
import java.util.List;


public class MuseumCollection {
    private List<Museum> museums;

    public MuseumCollection() {
        this.museums = new LinkedList<Museum>();
    }

    public List<Museum> getMuseums() {
        return this.museums;
    }

    public void addMuseum(Museum aMuseum) {
        this.museums.add(aMuseum);
    }
}
