import java.util.List;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.mapper.DefaultMapper;

public class xstream_class_12 {
    public static class ListToStringXStreamConverter implements Converter {

        private String alias;

        public ListToStringXStreamConverter(String alias) {
            super();
            this.alias = alias;
        }

        public boolean canConvert(Class type) {
            return true;
        }

        public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
            @SuppressWarnings("unchecked")
            List<String> list = (List<String>) source;

            for (String string : list) {
                writer.startNode(alias);
                writer.setValue(string);
                writer.endNode();
            }

        }

        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            throw new UnsupportedOperationException("ListToStringXStreamConverter does not offer support for unmarshal operation");
        }

        public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context, Mapper mapper) {
            marshal(source, writer, context);
        }

        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context, Mapper mapper) {
            throw new UnsupportedOperationException("ListToStringXStreamConverter does not offer support for unmarshal operation");
        }
    }
}