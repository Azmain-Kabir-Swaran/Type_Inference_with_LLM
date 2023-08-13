package gwt;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HasText;

public class GwtExample {
    public static interface HasKeyDownHandlers {
        HandlerRegistration addKeyDownHandler(KeyDownHandler handler);
    }

    public static interface HasClickHandlers {
        HandlerRegistration addClickHandler(ClickHandler handler);
    }

    public static interface HasBlurHandlers {
        HandlerRegistration addBlurHandler(BlurHandler handler);
    }

    public static class ListItem extends ComplexPanel implements HasKeyDownHandlers, HasClickHandlers, HasBlurHandlers, HasText {
        public ListItem() {
            setElement(DOM.createElement("LI"));
        }

        public void add(Widget w) {
            super.add(w, getElement());
        }

        public void insert(Widget w, int beforeIndex) {
            super.insert(w, getElement(), beforeIndex, true);
        }

        public String getText() {
            return DOM.getInnerText(getElement());
        }

        public void setText(String text) {
            DOM.setInnerText(getElement(), (text == null) ? "" : text);
        }

        public void setId(String id) {
            DOM.setElementAttribute(getElement(), "id", id);
        }

        public HandlerRegistration addClickHandler(ClickHandler handler) {
            return addDomHandler(handler, ClickEvent.getType());
        }

        public HandlerRegistration addKeyDownHandler(KeyDownHandler handler) {
            return addDomHandler(handler, KeyDownEvent.getType());
        }

        public HandlerRegistration addBlurHandler(BlurHandler handler) {
            return addDomHandler(handler, BlurEvent.getType());
        }
    }
}