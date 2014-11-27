package tr.edu.tr.cs.sh;

import java.util.LinkedList;
import java.util.List;


public class PaintingCollection implements IPaintingCollections-degistir {

    private List<Painting> Paintings;

    public PaintingCollection() {
        this.Paintings = new LinkedList<Painting>();
    }

    public List<Painting> getPaintings() {
        return this.Paintings;
    }

    public void addPainting(Painting aPainting) {
        this.Paintings.add(aPainting);
    }

    public void deletePainting(Painting aPainting) {
        this.Paintings.remove(aPainting);
    }

    public void updatePainting(Painting aPainting) {
    }

}
