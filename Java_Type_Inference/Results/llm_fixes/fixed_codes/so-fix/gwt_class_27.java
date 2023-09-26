import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class gwt_class_27 implements EntryPoint {
    public void onModuleLoad() {
        final Button sendButton = new Button("Send");
        sendButton.getElement().setId("button");
        RootPanel.get().getElement().appendChild(sendButton.getElement());

        NodeList<Element> buttonElement = Document.get().getElementsByTagName("button");
        if (buttonElement != null && buttonElement.getLength() > 0) {
            buttonElement.getItem(0).setNodeValue("Changed");
        } else {
            com.google.gwt.core.client.GWT.log("Can't select button");
        }
    }
}