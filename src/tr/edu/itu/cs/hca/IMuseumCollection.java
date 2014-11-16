package tr.edu.itu.cs.hca;

import java.util.List;


public interface IMuseumCollection {
    public List<Museum> getMuseums();

    public void addMuseum(Museum aMuseum);

    public void deleteMuseum(Museum aMuseum);

    public void updateMuseum(Museum aMuseum);
}
