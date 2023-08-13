import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class gwt_class_34 {

  public static void main(String... args) {
    FormPanel form = null;
    Button submit = null;

    form = new FormPanel();
    form.setEncoding(FormPanel.ENCODING_MULTIPART);
    RootPanel.get().add(form);
		
    submit = new Button("OK");
    submit.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        // button clicked confirmed
      }
    });
    RootPanel.get().add(submit);
  }
}