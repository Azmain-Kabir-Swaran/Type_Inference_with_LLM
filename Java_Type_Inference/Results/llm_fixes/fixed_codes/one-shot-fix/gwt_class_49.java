package gwt;

import java.util.ArrayList;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.dom.client.BodyElement;

public class gwt_class_49 {
    
    private void putElementLinkIDsInList(BodyElement elt, ArrayList<String> list) {
        // implementation here
    }

    /**
     * Find all anchor tags and if any point outside the site, redirect them to a
     * "blocked" page.
     */
    private void rewriteLinksIterative() {
        ArrayList<String> links = new ArrayList<>();
        putElementLinkIDsInList(Document.get().getBody(), links);
        for (int i = 0; i < links.size(); i++) {
            Element elt = DOM.getElementById(links.get(i));
            rewriteLink(elt, "www.example.com");
        }
    }

    /**
     * Block all accesses out of the website that don't match 'sitename'
     * 
     * @param element An anchor link element
     * @param sitename name of the website to check. e.g. "www.example.com"
     */
    private void rewriteLink(Element element, String sitename) {
        String href = element.getPropertyString("href");
        if (null == href) {
            return;
        }

        // We want to re-write absolute URLs that go outside of this site
        if (href.startsWith("http://") && !href.startsWith("http://" + sitename + "/")) {
            element.setPropertyString("href", "http://" + sitename + "/Blocked.html");
        }
    }
}