import java.io.Writer;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;

public class xstream_class_39 {
    private static XStream xstream = new XStream() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                boolean cdata;
                boolean isNeedUpper;

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else if (isNeedUpper) {
                        writer.write(text.toUpperCase());
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    };
}