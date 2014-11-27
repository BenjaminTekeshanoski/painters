package tr.edu.tr.cs.sh;

import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;


public class TrendsPage-dehis extends BasePage {

    public TrendsPage() {

        Link idiomList = new Link("idiomList") {
            @Override
            public void onClick() {
                this.setResponsePage(new IdiomList());
            }
        };
        this.add(idiomList);

    }

}
