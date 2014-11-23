package tr.edu.itu.cs.ms;

import tr.edu.itu.cs.db.BasePage;


public final class CommentEditPage extends BasePage {
    public CommentEditPage(Comment aComment) {
        this.add(new CommentEditForm("comment_edit", aComment, true));
    }

    public CommentEditPage(Comment aComment, boolean newCommentFlag) {
        this.add(new CommentEditForm("comment_edit", aComment, newCommentFlag));
    }
}
