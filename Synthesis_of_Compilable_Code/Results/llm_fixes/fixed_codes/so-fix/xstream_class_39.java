import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.WriterWrapper;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XmlFriendlyWriter;

import java.io.Writer;

public class xstream_class_39 {

    private static XStream xstream = new XStream(){
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // Add CDATA block
                boolean cdata;//I need to add cdata for some fields only
                boolean isNeedUpper;//only some will need this

                protected void writeText(XmlFriendlyWriter writer, String text) {
                    if (cdata) {
                        writer.startNode("![CDATA[");
                        writer.setValue(text);
                        writer.endNode();
                    } else if (isNeedUpper){
                        writer.setValue(text.toUpperCase());
                    }
                    else writer.setValue(text);
                }
            };
        }
    };
}