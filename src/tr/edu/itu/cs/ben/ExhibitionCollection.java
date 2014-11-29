package tr.edu.itu.cs.ben;

import java.util.LinkedList;
import java.util.List;


public class ExhibitionCollection implements IExhibitionCollection {
    private List<Exhibition> exhibitions;

    public ExhibitionCollection() {
        this.exhibitions = new LinkedList<Exhibition>();
    }

    public List<Exhibition> getExhibitions() {
        return this.exhibitions;
    }

    public void addExhibition(Exhibition aExhibition) {
        this.exhibitions.add(aExhibition);
    }

    public void deleteExhibition(Exhibition aExhibition) {
        this.exhibitions.remove(aExhibition);
    }

    public void updateExhibition(Exhibition aExhibition) {
    }
}
