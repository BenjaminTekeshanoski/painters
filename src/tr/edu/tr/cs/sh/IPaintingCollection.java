package tr.edu.tr.cs.sh;

import java.util.List;


//import tr.edu.itu.cs.hca.Museum;

public interface IPaintingCollection {

    public List<Painting> getPaintings();

    public void addPainting(Painting aPainting);

    public void deletePainting(Painting aPainting);

    public void updatePainting(Painting aPainting);
}
