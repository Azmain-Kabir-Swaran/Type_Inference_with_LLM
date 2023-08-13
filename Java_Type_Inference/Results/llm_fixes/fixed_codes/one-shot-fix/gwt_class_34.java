import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.SubmitEvent;
import com.google.gwt.event.dom.client.SubmitHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class gwt_class_34 {
    public static void main(String arg[]) {
        FormPanel form = new FormPanel();
        Button submit = new Button("Submit");

        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setAction("action_url"); // replace with your actual action URL
        form.add(submit);

        submit.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                // button clicked confirmed
            }
        });

        HandlerRegistration formSubmitHandler = form.addSubmitHandler(new SubmitHandler() {
            public void onSubmit(SubmitEvent event) {
                // form submitted
            }
        });

        RootPanel.get().add(form);
    }
}