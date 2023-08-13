package gwt;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import java.util.ArrayList;
import com.google.gwt.user.client.DOM;
import com.google.gwt.dom.client.BodyElement;

//ID = 3954392

public class gwt_class_49 {
    private native void putElementLinkIDsInList(BodyElement elt, ArrayList<String> list) /*-{
        // Code goes here
    }-*/;

    private native void rewriteLink(Element element, String sitename) /*-{
        // Code goes here
    }-*/;

    public void rewriteLinksIterative() {
        ArrayList<String> links = new ArrayList<String>();
        putElementLinkIDsInList(Document.get().getBody().cast(), links);
        for (int i = 0; i < links.size(); i++) {
            Element elt = DOM.getElementById(links.get(i));
            rewriteLink(elt, "www.example.com");
        }
    }
}