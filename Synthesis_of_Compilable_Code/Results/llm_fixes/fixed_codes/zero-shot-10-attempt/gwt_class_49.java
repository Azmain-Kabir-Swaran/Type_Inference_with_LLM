package gwt;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.BodyElement;
import com.google.gwt.user.client.DOM;

import java.util.ArrayList;

//ID = 3954392

public class gwt_class_49 {
    private void putElementLinkIDsInList(BodyElement elt, ArrayList<String> list) {
    }/*-{

    /**
     * Find all anchor tags and if any point outside the site, redirect them to a
     * "blocked" page.
     */
    private void rewriteLinksIterative() {
        ArrayList<String> links = new ArrayList<String>();
        putElementLinkIDsInList(Document.get().getBody(), links);
        for (int i = 0; i < links.size(); i++) {
            com.google.gwt.user.client.Element elt = com.google.gwt.user.client.DOM.getElementById(links.get(i));
            rewriteLink(elt, "www.example.com");
        }
    }

    /**
     * Block all accesses out of the website that don't match 'sitename'
     *
     * @param element
     *          An anchor link element
     * @param sitename
     *          name of the website to check. e.g. "www.example.com"
     */
    private void rewriteLink(com.google.gwt.user.client.Element element, String sitename) {
        String href = com.google.gwt.user.client.DOM.getElementProperty(element, "href");
        if (null == href) {
            return;
        }

        // We want to re-write absolute URLs that go outside of this site
        if (href.startsWith("http://")
                && !href.startsWith("http://" + sitename + "/")) {
            com.google.gwt.user.client.DOM.setElementProperty(element, "href", "http://" + sitename
                    + "/Blocked.html");
        }
    }
}