package tr.edu.itu.cs.ms;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import tr.edu.itu.cs.db.BasePage;


public final class CommentDetailPage extends BasePage {
    private Comment _comment;

    public CommentDetailPage(Comment aComment) {
        this._comment = aComment;

        this.add(new Label("comment", aComment.getCom()));
        this.add(new Label("owner", aComment.getOwner()));
        this.add(new Label("target", aComment.getTarget()));

        Link editLink = new Link("edit_link") {
            @Override
            public void onClick() {
                CommentDetailPage parent = (CommentDetailPage) this.getParent();
                this.setResponsePage(new CommentEditPage(parent.getComment(),
                        false));
            }
        };
        this.add(editLink);
    }

    public Comment getComment() {
        return this._comment;
    }
}
