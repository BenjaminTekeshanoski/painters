package tr.edu.tr.cs.sh;

import java.util.LinkedList;
import java.util.List;


public class YourPaintingCollection implements IYourPaintingCollection {

    private List<YourPainting> YourPaintings;

    public YourPaintingCollection() {
        this.YourPaintings = new LinkedList<YourPainting>();
    }

    public List<YourPainting> getYourPaintings() {
        return this.YourPaintings;
    }

    public void addYourPainting(YourPainting aYourPainting) {
        this.YourPaintings.add(aYourPainting);
    }

    public void deleteYourPainting(YourPainting aYourPainting) {
        this.YourPaintings.remove(aYourPainting);
    }

    public void updateYourPainting(YourPainting aYourPainting) {
    }

}
