import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.AbstractXmlWriter;
import com.thoughtworks.xstream.io.xml.XmlFriendlyWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.hibernate.collection.PersistentSet;

import java.util.HashSet;

public class xstream_class_15 {
    public static void main(String arg[]){
        XStream xs = new XStream(new XppDriver() {
            @Override
            public HierarchicalStreamWriter createWriter(java.io.Writer out) {
                return new XmlFriendlyWriter(out) {
                    @Override
                    public void startNode(String name, Class clazz) {
                        if (AbstractXmlWriter.CDATA_NODES.contains(name)) {
                            super.startNode(name, clazz);
                        } else {
                            super.startNode(name);
                        }
                    }
                };
            }
        });
        xs.registerConverter(new CollectionConverter(xs.getMapper()) {
            @Override
            public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
                super.marshal(new HashSet((PersistentSet) source), writer, context);
            }

            @Override
            public boolean canConvert(Class type) {
                return type.isAssignableFrom(PersistentSet.class);
            }
        }, XStream.PRIORITY_VERY_HIGH);
        Object processInstance = null;
        String s = xs.toXML(processInstance);
    }
}