import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;

public class xstream_class_24 {
    public static class DetailDollarsConverter implements Converter {
        public DetailDollarsConverter() {
            super();
        }

        @Override
        public void marshal(Object obj, HierarchicalStreamWriter writer, MarshallingContext context) {
            writer.startNode("node4");
            writer.setValue(Double.toString(20));
            writer.endNode();
        }

        @Override
        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            return null;
        }

        @SuppressWarnings("rawtypes")
        @Override
        public boolean canConvert(Class clazz) {
            return false;
        }
    }
}