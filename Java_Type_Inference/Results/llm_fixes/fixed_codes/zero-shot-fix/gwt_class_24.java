import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class GwtClass24 implements EntryPoint {
  
  public abstract class AbstractNotificationWidget extends Composite implements ClickHandler {

    protected abstract String getUniqueId();

    @Override
    protected void initWidget(Widget widget) {
      super.initWidget(widget);
      Element element = getElement();
      element.setId(getUniqueId());
      element.setClassName("notification");
      element.getStyle().setProperty("display", "none");
    }

    @Override
    protected void onAttach() {
      super.onAttach();
      addDomHandler(this, ClickEvent.getType());
    }

    @Override
    public void onClick(ClickEvent event) {
      doClick(getUniqueId());
    }

    protected native void doClick(String name) /*-{
      $wnd.$("#" + name).slideUp("slow");
      $wnd.$("div", "#" + name).fadeOut("slow");
    }-*/;

  }

  public class ErrorNotificationWidget extends AbstractNotificationWidget {

    private final String uniqueId;

    public ErrorNotificationWidget(String title, String message) {
      uniqueId = Document.get().createUniqueId();
    }

    @Override
    protected String getUniqueId() {
      return uniqueId;
    }

  }

  @Override
  public void onModuleLoad() {
    ErrorNotificationWidget errorWidget = new ErrorNotificationWidget("Error", "An error has occurred.");
    RootPanel.get().add(errorWidget);
  }
}