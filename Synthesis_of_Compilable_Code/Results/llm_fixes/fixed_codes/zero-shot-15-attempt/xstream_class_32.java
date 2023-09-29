import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.hibernate.converter.HibernateMapper;
import com.thoughtworks.xstream.mapper.MapperWrapper;

public class xstream_class_32 {
    public static XStream instanciateXstreamForHibernate() {
        XStream xstream1 = new XStream() {
            protected MapperWrapper wrapMapper(final MapperWrapper next) {
                return new HibernateMapper(next);
            }
        };
        return xstream1;
    }
}