package tr.edu.itu.cs.hca;

import java.util.LinkedList;
import java.util.List;


public class MuseumCollection implements IMuseumCollection {
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

    public void deleteMuseum(Museum aMuseum) {
        this.museums.remove(aMuseum);
    }

    public void updateMuseum(Museum aMuseum) {
        // this.museums.update(aMuseum);
    }
}
