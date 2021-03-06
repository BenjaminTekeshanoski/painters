package tr.edu.itu.cs.hca;

import java.util.LinkedList;
import java.util.List;


public class MuseumCollection implements IMuseumCollection {
    private MuseumCollectionJDBC jdbc;
    private List<Museum> museums;

    public MuseumCollection() {
        jdbc = new MuseumCollectionJDBC();
        this.museums = new LinkedList<Museum>();
        museums = jdbc.getMuseums();
    }

    public List<Museum> getMuseums() {
        return this.museums;
    }

    public void addMuseum(Museum aMuseum) {
        this.museums.add(aMuseum);
        jdbc.addMuseum(aMuseum);
    }

    public void deleteMuseum(Museum aMuseum) {
        this.museums.remove(aMuseum);
        jdbc.deleteMuseum(aMuseum);
    }

    public void updateMuseum(Museum aMuseum) {
        jdbc.updateMuseum(aMuseum);
    }
}
