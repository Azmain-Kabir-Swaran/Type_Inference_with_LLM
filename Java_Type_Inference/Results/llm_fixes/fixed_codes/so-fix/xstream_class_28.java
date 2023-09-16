import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import java.util.Map;
import java.util.HashMap;

public class xstream_class_28 {

    public static class MapEntryConverter implements Converter {

        private final Mapper mapper;

        public MapEntryConverter(Mapper mapper) {
            this.mapper = mapper;
        }

        @Override
        public boolean canConvert(Class clazz) {
            return Map.class.isAssignableFrom(clazz);
        }

        @Override
        public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
            Map<String, Integer> map = (Map<String, Integer>) value;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey().toString();
                String fieldName = mapper.serializedMember(null, Map.class, key);
                writer.startNode(fieldName);
                writer.setValue(entry.getValue().toString());
                writer.endNode();
            }
        }

        @Override
        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            Map<String, Integer> map = new HashMap<String, Integer>();
            while (reader.hasMoreChildren()) {
                reader.moveDown();
                String key = reader.getNodeName();
                String value = reader.getValue();
                map.put(key, Integer.parseInt(value));
                reader.moveUp();
            }
            return map;
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("foo", 1);
        map.put("bar", 2);

        XStream xstream = new XStream(new Dom4JDriver());
        xstream.registerConverter(new MapEntryConverter(xstream.getMapper()));
        xstream.alias("map", Map.class);
        String xml = xstream.toXML(map);
        System.out.println(xml);
    }
}