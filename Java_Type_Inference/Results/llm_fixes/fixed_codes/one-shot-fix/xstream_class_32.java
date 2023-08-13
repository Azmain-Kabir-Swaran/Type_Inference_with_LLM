import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.hibernate.AbstractHibernateConverter;
import com.thoughtworks.xstream.converters.hibernate.HibernateConverter;
import com.thoughtworks.xstream.converters.hibernate.HibernateMapper;
import com.thoughtworks.xstream.converters.hibernate.HibernateProxyConverter;
import com.thoughtworks.xstream.mapper.MapperWrapper;

public class xstream_class_32 {
    public static XStream instantiateXstreamForHibernate() {
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

class HibernatePersistentCollectionConverter extends AbstractHibernateConverter {
    public HibernatePersistentCollectionConverter(HibernateMapper mapper) {
        super(mapper);
    }
}

class HibernatePersistentMapConverter extends AbstractHibernateConverter {
    public HibernatePersistentMapConverter(HibernateMapper mapper) {
        super(mapper);
    }
}

class HibernatePersistentSortedMapConverter extends AbstractHibernateConverter {
    public HibernatePersistentSortedMapConverter(HibernateMapper mapper) {
        super(mapper);
    }
}

class HibernatePersistentSortedSetConverter extends AbstractHibernateConverter {
    public HibernatePersistentSortedSetConverter(HibernateMapper mapper) {
        super(mapper);
    }
}