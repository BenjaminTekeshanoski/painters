package tr.edu.itu.cs.ms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class CommentCollectionJDBC implements ICommentCollection {
    private Connection _db;

    public CommentCollectionJDBC(String dbFilePath) {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }

        try {
            String jdbcURL = "jdbc:sqlite:" + dbFilePath;
            this._db = DriverManager.getConnection(jdbcURL);
        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
    }

    public List<Comment> getComments() {
        List<Comment> comments = new LinkedList<Comment>();
        try {
            String query = "SELECT id, owner,comment,target FROM COMMENT";
            Statement statement = this._db.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                Integer id = results.getInt("id");
                String comment = results.getString("comment");
                String owner = results.getString("owner");
                String target = results.getString("target");

                Comment comment1 = new Comment(comment, owner, target, id);

                comments.add(comment1);
            }
            results.close();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
        return comments;
    }

    public void addComment(Comment comment) {
        try {
            String query = "INSERT INTO COMMENT(comment,owner,target,id) VALUES(?,?,?,?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, comment.getCom());
            statement.setString(2, comment.getOwner());
            statement.setString(3, comment.getTarget());
            statement.setInt(4, comment.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void deleteComment(Comment comment) {
        try {
            String query = "DELETE FROM COMMENT WHERE (id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setInt(1, comment.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void updateComment(Comment comment) {
        try {
            String query = "UPDATE COMMENT SET comment = ?, owner = ?, target = ? WHERE(id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, comment.getCom());
            statement.setString(2, comment.getOwner());
            statement.setString(3, comment.getTarget());
            statement.setInt(4, comment.getId());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }
}