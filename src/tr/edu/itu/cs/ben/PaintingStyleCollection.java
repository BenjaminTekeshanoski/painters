package tr.edu.itu.cs.ben;

import java.util.LinkedList;
import java.util.List;


public class PaintingStyleCollection implements IPaintingStyleCollection {
    private List<PaintingStyle> paintingstyles;

    public PaintingStyleCollection() {
        this.paintingstyles = new LinkedList<PaintingStyle>();
    }

    public List<PaintingStyle> getPaintingStyles() {
        return this.paintingstyles;
    }

    public void addPaintingStyle(PaintingStyle aPaintingStyle) {
        this.paintingstyles.add(aPaintingStyle);
    }

    public void deletePaintingStyle(PaintingStyle aPaintingStyle) {
        this.paintingstyles.remove(aPaintingStyle);
    }

    public void updatePaintingStyle(PaintingStyle aPaintingStyle) {
    }
}
