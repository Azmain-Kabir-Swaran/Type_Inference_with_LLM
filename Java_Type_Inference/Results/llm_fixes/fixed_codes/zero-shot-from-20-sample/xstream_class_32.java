package xstream;

import com.thoughtworks.xstream.XStream;
import xstream.converter.HibernatePersistentCollectionConverter;
import xstream.converter.HibernatePersistentMapConverter;
import xstream.converter.HibernatePersistentSortedMapConverter;
import xstream.converter.HibernatePersistentSortedSetConverter;
import xstream.converter.HibernateProxyConverter;
import xstream.mapper.HibernateMapper;
import com.thoughtworks.xstream.mapper.MapperWrapper;

public class xstream_class_32 {
    public static XStream instanciateXstreamForHibernate() {
        XStream xstream1 = new XStream() {
            protected MapperWrapper wrapMapper(final MapperWrapper next) {
                return new HibernateMapper(next);
            }
        };
        xstream1.registerConverter(new HibernateProxyConverter());
        xstream1.registerConverter(new HibernatePersistentCollectionConverter(xstream1.getMapper()));
        xstream1.registerConverter(new HibernatePersistentMapConverter(xstream1.getMapper()));
        xstream1.registerConverter(new HibernatePersistentSortedMapConverter(xstream1.getMapper()));
        xstream1.registerConverter(new HibernatePersistentSortedSetConverter(xstream1.getMapper()));
        return xstream1;
    }
}