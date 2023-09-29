import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;

public class xstream_class_24 {
	public class DetailDollarsConverter implements Converter {

		private Mapper mapper;
		private ReflectionProvider reflectionProvider;

		public DetailDollarsConverter(Mapper mapper, ReflectionProvider reflectionProvider) {
		    this.mapper = mapper;
		    this.reflectionProvider = reflectionProvider;
		}

		@Override
		public void marshal(Object obj, HierarchicalStreamWriter writer, MarshallingContext context) {
		    ReflectionConverter reflectionConverter = new ReflectionConverter(mapper, reflectionProvider);
		    reflectionConverter.marshal(obj, writer, context);

		    writer.startNode("node4");
		    writer.setValue(Double.toString(20));
		    writer.endNode();
		}

		@Override
		public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		    ReflectionConverter reflectionConverter = new ReflectionConverter(mapper, reflectionProvider);
		    return reflectionConverter.unmarshal(reader, context);
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean canConvert(Class clazz) {
		    Object o = null;
			return clazz.equals(o);
		}
	}
}