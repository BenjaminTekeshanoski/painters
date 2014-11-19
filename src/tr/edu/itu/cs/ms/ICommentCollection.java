package tr.edu.itu.cs.ms;

import java.util.List;


public interface ICommentCollection {
    public List<Comment> getComments();

    public void addComment(Comment aComment);

    public void deleteComment(Comment aComment);

    public void updateComment(Comment aComment);
}
