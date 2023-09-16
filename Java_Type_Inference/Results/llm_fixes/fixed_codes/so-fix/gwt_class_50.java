import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.*;

public class gwt_class_50 implements EntryPoint {
    public class ListItem extends ComplexPanel implements HasText, HasHTML, HasClickHandlers, HasKeyDownHandlers, HasBlurHandlers {
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

        public String getHTML() {
            return DOM.getInnerHTML(getElement());
        }

        public void setHTML(String html) {
            DOM.setInnerHTML(getElement(), (html == null) ? "" : html);
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

    public void onModuleLoad() {
      // Entry point code here
    }
}