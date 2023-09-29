package xstream;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import java.io.Writer;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XmlFriendlyWriter;

public class xstream_class_39 {

    private static XStream xstream = new XStream(new XppDriver() {
        @Override
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // Add CDATA block
                boolean cdata;//I need to add cdata for some fields only
                boolean isNeedUpper;//only some will need this

                protected void writeText(HierarchicalStreamWriter writer, String text) {
                    if (cdata) {
                        writer.startNode("");
                        writer.setValue("<![CDATA[");
                        writer.setValue(text);
                        writer.setValue("]]>");
                        writer.endNode();
                    } else if (isNeedUpper){
                        writer.startNode("");
                        writer.setValue(text.toUpperCase());
                        writer.endNode();
                    }
                    else writer.setValue(text);
                }
            };
        }
    });
}