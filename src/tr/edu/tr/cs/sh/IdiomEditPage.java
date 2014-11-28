package tr.edu.tr.cs.sh;

import tr.edu.itu.cs.db.BasePage;
//import tr.edu.itu.cs.hca.Museum;
//import tr.edu.itu.cs.hca.MuseumEditForm;


public class IdiomEditPage extends BasePage {

    public IdiomEditPage(Idiom aIdiom) {
        this.add(new IdiomEditForm("idiom_edit", aIdiom, true));
    }

    public IdiomEditPage(Idiom aIdiom, boolean newIdiomFlag) {
        this.add(new IdiomEditForm("idiom_edit", aIdiom, newIdiomFlag));
    }
}
