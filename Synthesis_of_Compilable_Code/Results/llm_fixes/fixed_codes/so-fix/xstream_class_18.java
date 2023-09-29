import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.AbstractReader;
import com.thoughtworks.xstream.io.AbstractWriter;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamReader;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriter;
import com.thoughtworks.xstream.io.MarshallingContext;
import com.thoughtworks.xstream.io.UnmarshallingContext;
import com.thoughtworks.xstream.mapper.Mapper;
import java.util.HashMap;
import java.util.Map;

public class xstream_class_18 {
    public static class MapToAttributesConverter implements Converter {

        private final Mapper mapper;

        public MapToAttributesConverter(Mapper mapper) {
            this.mapper = mapper;
        }

        @Override
        public boolean canConvert(Class<?> type) {
            return Map.class.isAssignableFrom(type);
        }

        @Override
        public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
            Map<String, String> map = (Map<String, String>) source;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                ExtendedHierarchicalStreamWriter extendedWriter = (ExtendedHierarchicalStreamWriter) writer;
                extendedWriter.startNode(mapper.serializedClass(String.class), Map.Entry.class);
                extendedWriter.addAttribute(mapper.serializedMember(Map.Entry.class, "key"), entry.getKey());
                extendedWriter.addAttribute(mapper.serializedMember(Map.Entry.class, "value"), entry.getValue());
                extendedWriter.endNode();
            }
        }

        @Override
        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            Map<String, String> map = new HashMap<String, String>();
            ExtendedHierarchicalStreamReader extendedReader = (ExtendedHierarchicalStreamReader) reader;
            while (extendedReader.hasMoreChildren()) {
                extendedReader.moveDown();
                String key = extendedReader.getAttribute(mapper.serializedMember(Map.Entry.class, "key"));
                String value = extendedReader.getAttribute(mapper.serializedMember(Map.Entry.class, "value"));
                map.put(key, value);
                extendedReader.moveUp();
            }
            return map;
        }
    }
}