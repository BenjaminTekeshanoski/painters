package tr.edu.itu.cs.db;

import java.util.Date;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;


public class HomePage extends WebPage {
    public HomePage() {
        Date now = new Date();
        Label dateTimeLabel = new Label("datetime", now.toString());
        this.add(dateTimeLabel);
    }
}
