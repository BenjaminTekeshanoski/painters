package tr.edu.itu.cs.users;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

import tr.edu.itu.cs.db.BasePage;


public class LogInPage extends BasePage {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public LogInPage() {
        Form form = new Form("regisForm") {
            protected void onSubmit() {
            }
        };
        final TextField password = new TextField("Password");
        final TextField nickname = new TextField("nickname");

        final Model<String> strMdl = Model.of("");
        final Label lb = new Label("result", strMdl);
        Button bt = new Button("button1") {
            public void onSubmit() {
                String result = RegisteredUser.loginUser(nickname.getInput(),
                        password.getInput());
                strMdl.setObject(result);
            }
        };
        bt.setDefaultFormProcessing(false);

        form.add(lb);
        form.add(bt);
        form.add(nickname);
        form.add(password);
        this.add(form);

    }
}
