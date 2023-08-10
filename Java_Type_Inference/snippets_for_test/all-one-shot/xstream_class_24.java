package xstream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.MarshallingContext;
//ID=2456909

public class xstream_class_24 {
	public class DetailDollarsConverter extends ReflectionConverter {

		public DetailDollarsConverter(Mapper mapper,
		        ReflectionProvider reflectionProvider) {
		    super(mapper, reflectionProvider);
		}

		@Override
		public void marshal(Object obj, HierarchicalStreamWriter writer,
		        MarshallingContext context) {
		    super.marshal(obj,writer,context);

		    writer.startNode("node4");
		    writer.setValue(Double.toString(20));
		    writer.endNode();
		}

		@Override
		public Object unmarshal(HierarchicalStreamReader reader,
		        UnmarshallingContext context) {
		    return super.unmarshal(reader,context);
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean canConvert(Class clazz) {
		    Object o=null;
			return clazz.equals(o);
		}
	}
}