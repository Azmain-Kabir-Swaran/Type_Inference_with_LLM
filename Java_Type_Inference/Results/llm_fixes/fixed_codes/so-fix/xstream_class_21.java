import java.util.Map;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.mapper.Mapper;

public class xstream_class_21 {
    static class MyConverter implements Converter {

        private final Map<String, String> attributes;
        private final Class<?> clazz;
        private final ReflectionProvider reflectionProvider;

        public MyConverter(Mapper mapper, ReflectionProvider reflectionProvider,
                Class<?> clazz, Map<String, String> attributes) {
            this.reflectionProvider = reflectionProvider;
            this.attributes = attributes;
            this.clazz = clazz;
        }

        public boolean canConvert(Class<?> cls) {
            return cls == clazz;
        }

        public void marshal(Object value, HierarchicalStreamWriter writer,
                MarshallingContext context) {
            for (String key : attributes.keySet()) {
                writer.addAttribute(key, attributes.get(key));
            }
            Converter converter = new ReflectionConverter(context.getMapper(), reflectionProvider);
            converter.marshal(value, writer, context);
        }

        public Object unmarshal(HierarchicalStreamReader arg0,
                UnmarshallingContext arg1) {
            return null;
        }

    }
}