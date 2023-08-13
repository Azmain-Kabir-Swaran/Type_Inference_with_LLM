import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.XStream;
import java.io.Writer;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class xstream_class_39 {

    private static XStream xstream = new XStream(new XppDriver() {
        @Override
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // Add CDATA block
                boolean cdata;
                boolean isNeedUpper;

                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                public void setValue(String text) {
                    if (cdata) {
                        super.setValue("<![CDATA[" + text + "]]>");
                    } else if (isNeedUpper) {
                        super.setValue(text.toUpperCase());
                    } else {
                        super.setValue(text);
                    }
                }

                public void endNode() {
                    super.endNode();
                }
            };
        }
    });
}