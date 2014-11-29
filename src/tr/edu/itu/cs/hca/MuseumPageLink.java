package tr.edu.itu.cs.hca;

import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.users.User;


public class MuseumPageLink extends Link {

    public MuseumPageLink(String id) {
        super(id);
    }

    @Override
    public void onClick() {
        if (User.user.getAccesslevel() < 3) {
            this.setResponsePage(new MuseumPageUser());
        } else {
            this.setResponsePage(new MuseumPage());
        }
    }
}
