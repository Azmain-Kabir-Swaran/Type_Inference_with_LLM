import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.xppdom.XppDomDriver;

public class xstream_class_32 {
    static class HibernateMapper extends MapperWrapper {
        public HibernateMapper(MapperWrapper wrapped) {
            super(wrapped);
        }

        @Override
        public boolean shouldSerializeMember(Class definedIn, String fieldName) {
            return definedIn != Object.class ? super.shouldSerializeMember(definedIn, fieldName) : false;
        }
    }

    static class HibernateProxyConverter implements Converter {
        @Override
        public boolean canConvert(Class type) {
            return false;
        }

        @Override
        public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {

        }

        @Override
        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            return null;
        }
    }

    static class HibernatePersistentCollectionConverter implements Converter {
        @Override
        public boolean canConvert(Class type) {
            return false;
        }

        @Override
        public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {

        }

        @Override
        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            return null;
        }
    }

    static class HibernatePersistentMapConverter implements Converter {
        @Override
        public boolean canConvert(Class type) {
            return false;
        }

        @Override
        public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {

        }

        @Override
        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            return null;
        }
    }

    static class HibernatePersistentSortedMapConverter implements Converter {
        @Override
        public boolean canConvert(Class type) {
            return false;
        }

        @Override
        public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {

        }

        @Override
        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            return null;
        }
    }

    static class HibernatePersistentSortedSetConverter implements Converter {
        @Override
        public boolean canConvert(Class type) {
            return false;
        }

        @Override
        public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {

        }

        @Override
        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            return null;
        }
    }

    public static XStream instantiateXstreamForHibernate() {
        XStream xstream1 = new XStream(new XppDomDriver(new XmlFriendlyNameCoder("_-", "_")));
        xstream1.registerConverter(new HibernateProxyConverter());
        xstream1.registerConverter(new HibernatePersistentCollectionConverter());
        xstream1.registerConverter(new HibernatePersistentMapConverter());
        xstream1.registerConverter(new HibernatePersistentSortedMapConverter());
        xstream1.registerConverter(new HibernatePersistentSortedSetConverter());
        return xstream1;
    }
}