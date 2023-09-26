import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.SubmitEvent;
import com.google.gwt.event.dom.client.SubmitHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FormPanel;

public class gwt_class_34 implements EntryPoint {
    public void onModuleLoad() {
        FormPanel form = null;
        Button submit = null;

        form = FormPanel.wrap((Element) Document.get().getElementById("MyForm"));
        form.setEncoding(FormPanel.ENCODING_MULTIPART);

        submit = Button.wrap((Element) Document.get().getElementById("OK"));
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