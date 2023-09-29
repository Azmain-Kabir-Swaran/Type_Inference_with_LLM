import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.WriterWrapper;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

import java.io.Writer;

public class xstream_class_39 {

    private static XStream xstream = new XStream(new XppDriver() {
        @Override
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(new WriterWrapper(out) {
                // Add CDATA block
                boolean cdata;//I need to add cdata for some fields only
                boolean isNeedUpper;//only some will need this

                @Override
                public void setValue(String text) {
                    if (cdata) {
                        super.startNode("");
                        super.writeCDATA(text);
                        super.endNode();
                    } else if (isNeedUpper) {
                        super.startNode("");
                        super.setValue(text.toUpperCase());
                        super.endNode();
                    } else {
                        super.setValue(text);
                    }
                }

                @Override
                public void startNode(String name, Class<?> clazz) {
                    super.startNode(name, clazz);
                }

                @Override
                public void endNode() {
                    super.endNode();
                }
            });
        }
    });
}