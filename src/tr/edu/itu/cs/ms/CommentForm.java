package tr.edu.itu.cs.ms;

import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Check;
import org.apache.wicket.markup.html.form.CheckGroup;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import tr.edu.itu.cs.db.WicketApplication;


public class CommentForm extends Form {
    private List<Comment> selectedComments;

    public CommentForm(String id) {
        super(id);
        this.selectedComments = new LinkedList<Comment>();
        CheckGroup commentCheckGroup = new CheckGroup("selected_comments",
                this.selectedComments);
        this.add(commentCheckGroup);

        WicketApplication app = (WicketApplication) this.getApplication();
        ICommentCollection collection = app.getCollection();
        List<Comment> comments = collection.getComments();

        PropertyListView commentListView = new PropertyListView("comment_list",
                comments) {
            @Override
            protected void populateItem(ListItem item) {
                Comment comment = (Comment) item.getModelObject();
                CommentDetailPageLink commentLink = new CommentDetailPageLink(
                        "museum_link", comment);
                commentLink.add(new Label("name"));
                item.add(new Check("selected", item.getModel()));
                item.add(commentLink);
            }
        };
        commentCheckGroup.add(commentListView);
    }

    @Override
    public void onSubmit() {
        WicketApplication app = (WicketApplication) this.getApplication();
        ICommentCollection collection = app.getCollection();
        for (Comment comment : this.selectedComments) {
            collection.deleteComment(comment);
        }
        this.setResponsePage(new CommentPage());
    }
}
