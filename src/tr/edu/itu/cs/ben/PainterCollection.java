package tr.edu.itu.cs.ben;

import java.util.LinkedList;
import java.util.List;


public class PainterCollection implements IPainterCollection {
    private List<Painter> painters;

    public PainterCollection() {
        this.painters = new LinkedList<Painter>();
    }

    public List<Painter> getPainters() {
        return this.painters;
    }

    public void addPainter(Painter aPainter) {
        this.painters.add(aPainter);
    }

    public void deletePainter(Painter aPainter) {
        this.painters.remove(aPainter);
    }

    public void updatePainter(Painter aPainter) {
    }
}
