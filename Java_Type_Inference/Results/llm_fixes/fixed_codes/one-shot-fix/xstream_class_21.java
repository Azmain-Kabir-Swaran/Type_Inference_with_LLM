package xstream;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

import java.util.Map;

public class xstream_class_21 {
    static class MyConverter implements Converter {

        private final Map<String, String> attributes;
        private final Class<?> clazz;
        private final Mapper mapper;

        public MyConverter(Mapper mapper, Class<?> clazz, Map<String, String> attributes) {
            this.mapper = mapper;
            this.clazz = clazz;
            this.attributes = attributes;
        }

        @Override
        public boolean canConvert(Class<?> type) {
            return clazz.isAssignableFrom(type);
        }

        @Override
        public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
            for (Map.Entry<String, String> entry : attributes.entrySet()) {
                writer.addAttribute(entry.getKey(), entry.getValue());
            }

            Converter converter = new ReflectionConverter(mapper, context.getMapper());
            converter.marshal(source, writer, context);
        }

        @Override
        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            return null;
        }
    }
}