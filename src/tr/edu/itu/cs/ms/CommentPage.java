package tr.edu.itu.cs.ms;

import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;
import tr.edu.itu.cs.users.User;


public class CommentPage extends BasePage {
    public CommentPage() {
        Link commentAddLink = new Link("add_comment") {
            @Override
            public void onClick() {
                Comment comment = new Comment("");
                this.setResponsePage(new CommentEditPage(comment));
            }
        };
        if (User.user.getAccesslevel() < 2)
            commentAddLink.setVisibilityAllowed(false);
        this.add(commentAddLink);

        CommentForm commentForm = new CommentForm("comment_form");
        this.add(commentForm);
    }
}
