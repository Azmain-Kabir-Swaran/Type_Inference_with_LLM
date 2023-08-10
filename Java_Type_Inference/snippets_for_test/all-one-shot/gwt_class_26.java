package gwt;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.FormHandler;
import com.google.gwt.event.logical.shared.FormSubmitCompleteEvent;
import com.google.gwt.event.logical.shared.FormSubmitEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
//ID = 2369187

public class gwt_class_26 {
	public static void main(String arg[]){
		final FormPanel formPanel = new FormPanel();
	    RootPanel.get("openId").add(formPanel);
	    VerticalPanel openIdContainer = new VerticalPanel();
	    formPanel.add(openIdContainer);

	    TextBox url = new TextBox();
	    url.setText("https://www.google.com/accounts/o8/id");
	    url.setName("j_username");
	    openIdContainer.add(url);

	    formPanel.setAction("j_spring_openid_security_check");
	    formPanel.setMethod(FormPanel.METHOD_POST);

	    Button btn = new Button("Open ID");
	    btn.addClickListener(new ClickListener() {
	        public void onClick(Widget sender)
	        {
	            formPanel.submit();
	        }
	    });
	    openIdContainer.add(btn);        

	    formPanel.addFormHandler(new FormHandler() {
	        public void onSubmit(FormSubmitEvent event)
	        {
	            System.out.println("On Submit invoked " +event.isCancelled());
	        }
	        public void onSubmitComplete(FormSubmitCompleteEvent event)
	        {
	            System.out.println("On Submit Complete invoked " + event.toString());
	        }

	    });
	}

}