package tr.edu.tr.cs.sh;

import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;


public class IdiomPage extends BasePage {

    public IdiomPage() {
        Link idiomAddLink = new Link("add_idiom") {
            @Override
            public void onClick() {
                Idiom idiom = new Idiom("");
                this.setResponsePage(new IdiomEditPage(idiom));
            }
        };
        this.add(idiomAddLink);

        IdiomForm idiomForm = new IdiomForm("idiom_form");
        this.add(idiomForm);
    }
}
