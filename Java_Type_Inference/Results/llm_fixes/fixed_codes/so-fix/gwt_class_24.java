import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class GwtClass24 {

    public abstract class AbstractNotificationWidget extends Composite implements ClickHandler {

        protected abstract String getUniqueId();

        @Override
        public HandlerRegistration addClickHandler(ClickHandler handler) {
            return addDomHandler(handler, ClickEvent.getType());
        }

        @Override
        public void onClick(ClickEvent event) {
            // Do nothing
        }

        protected native void doClick(String name) /*-{
            var self = this;
            $wnd.$("#" + name).click(function () {
                $wnd.$(this).slideUp("slow");
                $wnd.$("div", this).fadeOut("slow");
                self.onClick();
            });
        }-*/;

    }

    public class ErrorNotificationWidget extends AbstractNotificationWidget {

        private final String uniqueId;

        public ErrorNotificationWidget(String title, String message) {
            uniqueId = DOM.createUniqueId();

            Widget w = new Widget();
            initWidget(w);

            this.getElement().setId(uniqueId);
        }

        @Override
        protected String getUniqueId() {
            return this.uniqueId;
        }

        @Override
        protected void onLoad() {
            super.onLoad();
            addDomHandler(this, ClickEvent.getType());
        }
    }
}