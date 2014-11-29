package tr.edu.itu.cs.ben;

import java.util.List;


public interface IPaintingStyleCollection {
    public List<PaintingStyle> getPaintingStyles();

    public void addPaintingStyle(PaintingStyle aPaintingStyle);

    public void deletePaintingStyle(PaintingStyle aPaintingStyle);

    public void updatePaintingStyle(PaintingStyle aPaintingStyle);
}
