package tr.edu.itu.cs.hca;

import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.users.User;


public class MuseumDetailPageLink extends Link {
    private Museum _museum;

    public MuseumDetailPageLink(String id, Museum museum) {
        super(id);
        this._museum = museum;
    }

    @Override
    public void onClick() {
        if (User.user.getAccesslevel() < 3) {
            this.setResponsePage(new MuseumDetailPageUser(this._museum));
        } else {
            this.setResponsePage(new MuseumDetailPage(this._museum));
        }
    }
}
