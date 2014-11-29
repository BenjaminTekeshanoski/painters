package tr.edu.itu.cs.db;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import tr.edu.itu.cs.ben.ExhibitionPage;
import tr.edu.itu.cs.ben.PainterPage;
import tr.edu.itu.cs.ben.PaintingStylePage;
import tr.edu.itu.cs.hca.LocationPage;
import tr.edu.itu.cs.hca.MuseumPage;
import tr.edu.itu.cs.hca.Updates;
import tr.edu.itu.cs.ms.CommentPage;
import tr.edu.itu.cs.users.LogInPage;
import tr.edu.itu.cs.users.SingUpPage;
import tr.edu.itu.cs.users.User;
import tr.edu.tr.cs.sh.IdiomPage;
import tr.edu.tr.cs.sh.PaintingPage;
import tr.edu.tr.cs.sh.YourPaintingPage;


public class Navigation extends Panel {
    public Navigation(String id) {
        super(id);
        Link SingUpPage = new Link("SingUp") {

            @Override
            public void onClick() {
                this.setResponsePage(new SingUpPage());

            }

        };
        Link LogInPage = new Link("LogIn") {

            @Override
            public void onClick() {
                this.setResponsePage(new LogInPage());

            }

        };
        if (User.user.getAccesslevel() > 1) {
            LogInPage.setVisible(false);
            SingUpPage.setVisible(false);
        }
        this.add(LogInPage);
        this.add(SingUpPage);

        Link homePageLink = new Link("home") {
            @Override
            public void onClick() {
                this.setResponsePage(new HomePage());
            }
        };
        this.add(homePageLink);

        // Shuain//
        Link paintingPageLink = new Link("paintings") {
            @Override
            public void onClick() {
                this.setResponsePage(new PaintingPage()); // buraya
                                                          // oluþturduðunuz
                                                          // paintings page i
                                                          // ekleyin
            }
        };
        this.add(paintingPageLink);

        Link paintersPageLink = new Link("painters") {
            @Override
            public void onClick() {
                this.setResponsePage(new PainterPage()); // buraya
                                                         // oluþturduðunuz
                // painters page i ekleyin
            }
        };
        this.add(paintersPageLink);

        Link exhibitionsPageLink = new Link("exhibitions") {
            @Override
            public void onClick() {
                this.setResponsePage(new ExhibitionPage()); // buraya
                                                            // oluþturduðunuz
                // painters page i ekleyin
            }
        };
        this.add(exhibitionsPageLink);

        Link paintingstylePageLink = new Link("paintingstyles") {
            @Override
            public void onClick() {
                this.setResponsePage(new PaintingStylePage()); // buraya
                // oluþturduðunuz
                // painters page i ekleyin
            }
        };
        this.add(paintingstylePageLink);

        Link museumPageLink = new Link("museums") {
            @Override
            public void onClick() {
                this.setResponsePage(new MuseumPage());
            }
        };
        this.add(museumPageLink);

        Link locationPageLink = new Link("locations") {
            @Override
            public void onClick() {
                this.setResponsePage(new LocationPage());
            }
        };
        this.add(locationPageLink);

        Link updatesPageLink = new Link("updates") {
            @Override
            public void onClick() {
                this.setResponsePage(new Updates());
            }
        };
        this.add(updatesPageLink);

        // Shuain//
        Link idiomPageLink = new Link("idioms") {

            @Override
            public void onClick() {
                this.setResponsePage(new IdiomPage());
            }
        };
        this.add(idiomPageLink);

        Link contactPageLink = new Link("contact") {
            @Override
            public void onClick() {
                this.setResponsePage(new ContactPage());
            }
        };
        this.add(contactPageLink);

        Link reloadDbLink = new Link("reload_db") {
            @Override
            public void onClick() {
                WicketApplication app = (WicketApplication) this
                        .getApplication();
                app.createDB();
            }
        };
        this.add(reloadDbLink);

        // Shuaib//
        Link yourpaintingPageLink = new Link("yourpainting") {
            @Override
            public void onClick() {
                this.setResponsePage(new YourPaintingPage()); // buraya
                // oluþturduðunuz
                // paintings page iz
                // ekleyin
            }

        };
        this.add(yourpaintingPageLink);

        Link commentPageLink = new Link("comments") {
            @Override
            public void onClick() {
                this.setResponsePage(new CommentPage());
            }
        };
        this.add(commentPageLink);

    }

}
