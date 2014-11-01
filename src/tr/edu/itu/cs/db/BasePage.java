package tr.edu.itu.cs.db;

import java.util.Date;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;


public class BasePage extends WebPage {
    public BasePage() {
        this(null);
    }

    public BasePage(IModel model) {
        super(model);
        Date now = new Date();
        this.add(new Label("datetime", now.toString()));

        this.add(new Navigation("mainNavigation"));
    }
}
