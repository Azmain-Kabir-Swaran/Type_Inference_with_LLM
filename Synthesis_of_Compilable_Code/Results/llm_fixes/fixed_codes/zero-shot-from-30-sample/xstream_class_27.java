import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.converters.Converter;
import org.apache.commons.lang3.text.WordUtils;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import xstream.Content;

public class xstream_class_27 {
    private class ObjectContentConverter implements Converter {
        XStream xStream;

        private ObjectContentConverter(XStream xStream) {
            this.xStream = xStream;
        }

        @Override
        public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
            String className = WordUtils.uncapitalize(source.getClass().getSimpleName());
            xStream.aliasField(className, Content.class, "objectContent");
            xStream.marshal(source, writer);
        }

        @Override
        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            return null;
        }

        @Override
        public boolean canConvert(Class type) {
            return true;
        }
    }
}