package tr.edu.itu.cs.ms;

import org.apache.wicket.markup.html.link.Link;


public class CommentDetailPageLink extends Link {
    private Comment _comment;

    public CommentDetailPageLink(String id, Comment comment) {
        super(id);
        this._comment = comment;
    }

    @Override
    public void onClick() {
        this.setResponsePage(new CommentDetailPage(this._comment));
    }
}
