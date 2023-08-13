import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import java.util.HashMap;
import java.util.Map;

public class xstream_class_28 {
    public static class MapEntryConverter implements Converter {

        public boolean canConvert(Class<?> clazz) {
            return Map.class.isAssignableFrom(clazz);
        }

        public void marshal(Object value, HierarchicalStreamWriter writer,
                MarshallingContext context) {
            Map<String, Integer> map = (Map<String, Integer>) value;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                writer.startNode(entry.getKey());
                writer.setValue(entry.getValue().toString());
                writer.endNode();
            }
        }

        public void marshal(Object value, HierarchicalStreamWriter writer,
                MarshallingContext context) {
            Map<String, Integer> map = (Map<String, Integer>) value;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                writer.startNode(entry.getKey());
                writer.setValue(entry.getValue().toString());
                writer.endNode();
            }
        }

        public Object unmarshal(HierarchicalStreamReader reader,
                UnmarshallingContext context) {
            Map<String, Integer> map = new HashMap<String, Integer>();

            while (reader.hasMoreChildren()) {
                reader.moveDown();
                map.put(reader.getNodeName(), Integer.parseInt(reader.getValue()));
                reader.moveUp();
            }
            return map;
        }
    }
}