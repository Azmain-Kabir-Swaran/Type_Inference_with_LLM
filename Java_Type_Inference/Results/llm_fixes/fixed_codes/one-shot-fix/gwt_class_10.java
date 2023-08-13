import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class gwt_class_10 {
    public void main(){
        final FormPanel form =new FormPanel();
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
    }
}