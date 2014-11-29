package tr.edu.itu.cs.ben;

import java.util.List;


public interface IPainterCollection {
    public List<Painter> getPainters();

    public void addPainter(Painter bPainter);

    public void deletePainter(Painter bPainter);

    public void updatePainter(Painter bPainter);
}
