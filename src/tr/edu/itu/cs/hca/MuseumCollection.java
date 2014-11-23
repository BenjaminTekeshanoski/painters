package tr.edu.itu.cs.hca;

import java.util.LinkedList;
import java.util.List;


public class MuseumCollection implements IMuseumCollection {
    private List<Museum> museums;

    // private MuseumCollectionJDBC museumJDBC;

    public MuseumCollection() {
        this.museums = new LinkedList<Museum>();
    }

    /*
     * public void initMuseumsDB() { String jdbcURL =
     * System.getProperty("user.home") + File.separator + "itucsdb.sqlite";
     * this.museumJDBC = new MuseumCollectionJDBC(jdbcURL); museums =
     * museumJDBC.getMuseums(); }
     */

    public List<Museum> getMuseums() {
        return this.museums;
    }

    public void addMuseum(Museum aMuseum) {
        this.museums.add(aMuseum);
        // this.museumJDBC.addMuseum(aMuseum);
    }

    public void deleteMuseum(Museum aMuseum) {
        this.museums.remove(aMuseum);
        // this.museumJDBC.deleteMuseum(aMuseum);
    }

    public void updateMuseum(Museum aMuseum) {
        // this.museumJDBC.updateMuseum(aMuseum);
    }
}
