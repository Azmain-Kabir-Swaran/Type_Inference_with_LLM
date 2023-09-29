import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import org.hibernate.collection.PersistentSet;

import java.util.HashSet;

public class xstream_class_15 {
    public static void main(String arg[]) {
        XStream xs = new XStream(new XppDriver() {
            public HierarchicalStreamWriter createWriter(java.io.Writer out) {
                return new com.thoughtworks.xstream.io.xml.PrettyPrintWriter(out) {
                    protected String PREFIX_CDATA = "<![CDATA[";
                    protected String SUFFIX_CDATA = "]]>";
                    protected String PREFIX_MEDIA = "<media type=\"text\">";
                    protected String SUFFIX_MEDIA = "</media>";

                    protected void writeText(com.thoughtworks.xstream.io.xml.QuickWriter writer, String text) {
                        if (text.startsWith(PREFIX_CDATA) && text.endsWith(SUFFIX_CDATA)) {
                            writer.write(text);
                        } else if (text.startsWith(PREFIX_MEDIA) && text.endsWith(SUFFIX_MEDIA)) {
                            writer.write(text);
                        } else {
                            super.writeText(writer, text);
                        }
                    }
                };
            }
        }) {
            protected MapperWrapper wrapMapper(MapperWrapper next) {
                return new MapperWrapper(next) {
                    public boolean shouldSerializeMember(Class definedIn, String fieldName) {
                        if (definedIn == Object.class) {
                            return false;
                        }
                        return super.shouldSerializeMember(definedIn, fieldName);
                    }
                };
            }
        };
        xs.registerConverter(new Converter() {
            @Override
            public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
                org.hibernate.collection.PersistentSet ps = null;
                new HashSet<>(ps);
            }

            @Override
            public boolean canConvert(Class<?> type) {
                return type.isAssignableFrom(org.hibernate.collection.PersistentSet.class);
            }

            @Override
            public Object unmarshal(HierarchicalStreamReader reader, com.thoughtworks.xstream.converters.UnmarshallingContext context) {
                return null;
            }
        }, XStream.PRIORITY_VERY_HIGH);
        Object processInstance = null;
        String s = xs.toXML(processInstance);
    }
}