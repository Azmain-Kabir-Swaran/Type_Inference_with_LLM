package gwt;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class gwt_class_24 {

    public abstract static class AbstractNotificationWidget extends Composite implements ClickHandler {

        protected abstract String getUniqueId();

        protected native void doClick(String name) /*-{
            $wnd.$("#" + name).click(function () {
                $wnd.$(this).slideUp("slow");
                $wnd.$("div", this).fadeOut("slow");
            });
        }-*/;

        @Override
        public HandlerRegistration addClickHandler(ClickHandler handler) {
            return addHandler(handler, ClickEvent.getType());
        }

        @Override
        public void onClick(ClickEvent event) {
            doClick(getUniqueId());
        }

    }

    public static class ErrorNotificationWidget extends AbstractNotificationWidget {

        private final String uniqueId;

        public ErrorNotificationWidget(String title, String message) {
            uniqueId = DOM.createUniqueId();

            initWidget(new Widget());

            getElement().setId(uniqueId);

            addClickHandler(this);
        }

        @Override
        protected String getUniqueId() {
            return uniqueId;
        }
    }
}