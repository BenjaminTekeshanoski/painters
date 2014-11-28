package tr.edu.tr.cs.sh;

import org.apache.wicket.markup.html.link.Link;
//import tr.edu.itu.cs.hca.Museum;
//import tr.edu.itu.cs.hca.MuseumDetailPage;


public class IdiomDetailPageLink extends Link {

    private Idiom _idiom;

    public IdiomDetailPageLink(String id, Idiom idiom) {
        super(id);
        this._idiom = idiom;
    }

    @Override
    public void onClick() {
        this.setResponsePage(new IdiomDetailPage(this._idiom));
    }
}
