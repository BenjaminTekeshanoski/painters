package tr.edu.itu.cs.ms;

import java.util.LinkedList;
import java.util.List;


public class CommentCollection implements ICommentCollection {
    private List<Comment> comments;

    public CommentCollection() {
        this.comments = new LinkedList<Comment>();
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public void addComment(Comment aComment) {
        this.comments.add(aComment);
    }

    public void deleteComment(Comment aComment) {
        this.comments.remove(aComment);
    }

    public void updateComment(Comment aComment) {
    }
}
