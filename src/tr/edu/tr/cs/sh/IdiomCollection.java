package tr.edu.tr.cs.sh;

import java.util.LinkedList;
import java.util.List;


public class IdiomCollection implements IIdiomCollection {

    private List<Idiom> Idioms;

    public IdiomCollection() {
        this.Idioms = new LinkedList<Idiom>();
    }

    public List<Idiom> getIdioms() {
        return this.Idioms;
    }

    public void addIdiom(Idiom aIdiom) {
        this.Idioms.add(aIdiom);
    }

    public void deleteIdiom(Idiom aIdiom) {
        this.Idioms.remove(aIdiom);
    }

    public void updateIdiom(Idiom aIdiom) {
    }

}
