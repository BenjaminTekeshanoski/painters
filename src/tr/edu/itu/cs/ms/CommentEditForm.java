package tr.edu.itu.cs.ms;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import tr.edu.itu.cs.db.WicketApplication;


public class CommentEditForm extends Form {
    private boolean newComment;

    public CommentEditForm(String id, Comment aComment, boolean newCommentFlag) {
        super(id);
        CompoundPropertyModel model = new CompoundPropertyModel(aComment);
        this.setModel(model);

        this.add(new TextField("name"));
        this.add(new TextField("owner"));
        this.add(new TextField("target"));

        this.newComment = newCommentFlag;
    }

    @Override
    public void onSubmit() {
        Comment comment = (Comment) this.getModelObject();
        WicketApplication app = (WicketApplication) this.getApplication();
        ICommentCollection collection = app.getCommentCollection();

        if (this.newComment) {
            collection.addComment(comment);
        } else {
            collection.updateComment(comment);
        }
        this.setResponsePage(new CommentDetailPage(comment));
    }
}
