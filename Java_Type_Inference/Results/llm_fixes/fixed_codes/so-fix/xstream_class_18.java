import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import java.util.Map;
import java.util.HashMap;

public class xstream_class_18 {
    public static class MapToAttributesConverter implements Converter {

        public MapToAttributesConverter() {
        }

        @Override
        public boolean canConvert(Class type) {
            return Map.class.isAssignableFrom(type);
        }

        @Override
        public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
            Map<String, String> map = (Map<String, String>) source;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writer.addAttribute(entry.getKey(), entry.getValue().toString());
            }
        }

        @Override
        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            Map<String, String> map = new HashMap<String, String>();
            while (reader.hasMoreChildren()) {
                reader.moveDown();
                String key = reader.getNodeName();
                String value = reader.getValue();
                map.put(key, value);
                reader.moveUp();
            }
            return map;
        }
    }
}