import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class GwtClass22 extends Composite {

    private static GwtClass22UiBinder uiBinder = GWT.create(GwtClass22UiBinder.class);

    interface GwtClass22UiBinder extends UiBinder<Widget, GwtClass22> {}

    @UiField Label testObjectStringLabel;
    @UiField Label innerObjectStringLabel;
    @UiField VerticalPanel listObjectsPanel;
    @UiField Button button;
    @UiField Label errorMessageLabel;

    public GwtClass22(String firstName) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("button")
    void onClick(ClickEvent e) {
        // your code here
    }
}