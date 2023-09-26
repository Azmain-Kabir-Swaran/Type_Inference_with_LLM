package gwt;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.FormHandler;
import com.google.gwt.event.logical.shared.FormSubmitCompleteEvent;
import com.google.gwt.event.logical.shared.FormSubmitEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FormPanel;

public class gwt_class_26 {
    public static void main(String arg[]) {
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
        btn.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                formPanel.submit();
            }
        });
        openIdContainer.add(btn);

        formPanel.addFormHandler(new FormHandler() {
            public void onSubmit(com.google.gwt.event.logical.shared.FormSubmitEvent event) {
                System.out.println("On Submit invoked " + event.isCancelled());
            }

            public void onSubmitComplete(com.google.gwt.event.logical.shared.FormSubmitCompleteEvent event) {
                System.out.println("On Submit Complete invoked " + event.toString());
            }

        });
    }
}