package tr.edu.tr.cs.sh;

import java.util.List;


//import tr.edu.itu.cs.hca.Museum;

public interface IIdiomCollection {

    public List<Idiom> getIdioms();

    public void addIdiom(Idiom aIdiom);

    public void deleteIdiom(Idiom aIdiom);

    public void updateIdiom(Idiom aIdiom);

}
