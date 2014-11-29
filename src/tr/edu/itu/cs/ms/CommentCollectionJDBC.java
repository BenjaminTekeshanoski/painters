package tr.edu.itu.cs.ms;

import java.io.File;
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

    public CommentCollectionJDBC() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }

        try {
            String sqlite = "jdbc:sqlite:";
            String home = System.getProperty("user.home");
            String jdbcURL = sqlite + home + File.separator + "painters.sqlite";
            this._db = DriverManager.getConnection(jdbcURL);
        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
    }

    public List<Comment> getComments() {
        List<Comment> comments = new LinkedList<Comment>();
        try {
            String query = "SELECT id, name, owner, target FROM COMMENT";
            Statement statement = this._db.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                Integer id = results.getInt("id");
                String name = results.getString("name");
                Integer owner = results.getInt("owner");
                String target = results.getString("target");

                Comment comment = new Comment(name, owner, target);
                comment.setId(id);
                comments.add(comment);
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
            String query = "INSERT INTO COMMENT(name, owner, target) VALUES(?,?,?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, comment.getName());
            statement.setInt(2, comment.getOwner());
            statement.setString(3, comment.getTarget());
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
            String query = "UPDATE COMMENT SET name = ?,owner = ?, target = ? WHERE(id = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, comment.getName());
            statement.setInt(2, comment.getOwner());
            statement.setString(3, comment.getTarget());
            statement.setInt(4, comment.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }
}
