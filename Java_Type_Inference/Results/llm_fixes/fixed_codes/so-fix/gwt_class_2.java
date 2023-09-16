import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class gwt_class_2 implements EntryPoint {

   public void onModuleLoad() {
      final FormPanel form = new FormPanel();
      form.setAction("/myFormHandler");
      
      form.setEncoding(FormPanel.ENCODING_MULTIPART);
      form.setMethod(FormPanel.METHOD_POST);
      
      VerticalPanel panel = new VerticalPanel();
      panel.setSpacing(10);
      form.setWidget(panel);
      
      final TextBox tb = new TextBox();
      tb.setWidth("220");
      tb.setName("textBoxFormElement");
      panel.add(tb);
      
      ListBox lb = new ListBox();
      lb.setName("listBoxFormElement");
      lb.addItem("item1", "item1");
      lb.addItem("item2", "item2");
      lb.addItem("item3", "item3");
      lb.setWidth("220");
      panel.add(lb);
      
      FileUpload upload = new FileUpload();
      upload.setName("uploadFormElement");
      panel.add(upload);
      
      panel.add(new Button("Submit", new ClickHandler() {
         @Override
         public void onClick(ClickEvent event) {
            form.submit();					
         }
      }));
      
      form.addSubmitHandler(new FormPanel.SubmitHandler() {
         @Override
         public void onSubmit(FormPanel.SubmitEvent event) {
            if (tb.getText().length() == 0) {
               Window.alert("The text box must not be empty");
               event.cancel();
            }					
         }
      });
      
      form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
         @Override
         public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
            Window.alert(event.getResults());					
         }
      });
      
      DecoratorPanel decoratorPanel = new DecoratorPanel();
      decoratorPanel.add(form);
      RootPanel.get().add(decoratorPanel);
   }
}