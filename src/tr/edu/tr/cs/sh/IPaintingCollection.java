package tr.edu.tr.cs.sh;

import java.util.List;

import tr.edu.tr.cs.sh.Painting;
//import tr.edu.itu.cs.hca.Museum;

public interface IPaintingCollection-degistir {

    public List<Painting> getPaintings();

    public void addPainting(Painting aPainting);

    public void deletePainting(Painting aPainting);

    public void updatePainting(Painting aPainting);
}
