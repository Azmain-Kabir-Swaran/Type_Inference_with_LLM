import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

public class gwt_class_10 implements EntryPoint {
    public void onModuleLoad(){
        final FormPanel form = new FormPanel();
        VerticalPanel holder = new VerticalPanel();
        holder.add(new Label("User ID"));
        TextBox nameTextBox = new TextBox();
        nameTextBox.setName("userid");
        holder.add(nameTextBox);

        Button submitButton = new Button("Submit");
        holder.add(submitButton);
        form.add(holder);

        submitButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                form.submit();
            }
        });

        RootPanel.get().add(form);
    }
}