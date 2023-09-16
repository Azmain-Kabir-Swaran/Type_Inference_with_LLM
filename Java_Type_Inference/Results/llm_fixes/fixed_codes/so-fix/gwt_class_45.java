import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class GWTClass45 implements EntryPoint {
    public void onModuleLoad() {

        Label label = new Label("hello world");
        Button button = new Button("say something");
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                Window.alert("hello again");
            }
        });

        RootPanel.get().add(label);
        RootPanel.get().add(button);
    }
}