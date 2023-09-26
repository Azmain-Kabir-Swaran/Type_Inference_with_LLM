package gwt;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.SubmitEvent;
import com.google.gwt.event.dom.client.SubmitHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.dom.client.Element;

public class gwt_class_34 {
    public static void main(String arg[]) {
        FormPanel form = null;
        Button submit = null;

        form = FormPanel.wrap((Element)com.google.gwt.dom.client.Document.get().getElementById("MyForm"));
        form.setEncoding(FormPanel.ENCODING_MULTIPART);

        submit = Button.wrap((Element)com.google.gwt.dom.client.Document.get().getElementById("OK"));
        submit.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                // button clicked confirmed
            }
        });

        HandlerRegistration formSubmitHandler = form.addSubmitHandler(new SubmitHandler() {
            public void onSubmit(SubmitEvent event) {
            }
        });
    }
}