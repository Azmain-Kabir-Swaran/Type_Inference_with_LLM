public class gwt_class_6 {
    public static class Widget {
        protected void setElement() {}
        protected void setElement(Element element) {}
        protected Element getElement() {
            return null;
        }
    }

    public static class Element {}

    public static class DOM {
        public static Element createFieldSet() {
            return new Element();
        }

        public static Element createLegend() {
            return new Element();
        }

        public static void appendChild(Element parent, Element child) {}

        public static String getInnerHTML(Element element) {
            return "";
        }

        public static void setInnerHTML(Element element, String html) {}

        public static void removeChild(Element parent, Element child) {}
    }
    
    public static class TitledPanel extends Widget {
        private Element legend;
        private Widget content = null;
    
        public TitledPanel() {
            Element fieldset = DOM.createFieldSet();
            legend = DOM.createLegend();
            DOM.appendChild(fieldset, legend);
            setElement(fieldset);
        }
    
        public TitledPanel(String title) {
            this();
            setTitle(title);
        }
    
        public String getTitle() {
            return DOM.getInnerHTML(legend);
        }
    
        public void setTitle(String html) {
            DOM.setInnerHTML(legend, html);
        }
    
        public Widget getContent() {
            return content;
        }
    
        public void setContent(Widget content) {
            if (this.content != null) {
                DOM.removeChild(getElement(), this.content.getElement());
            }
    
            this.content = content;
    
            DOM.appendChild(getElement(), content.getElement());
        }
    }
}