import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;

public class xstream_class_12 {
	public static class ListToStringXStreamConverter implements Converter {

		private String alias;

		public ListToStringXStreamConverter(String alias) {
		    super();
		    this.alias = alias;
		}

		@SuppressWarnings("rawtypes")
		@Override
		public boolean canConvert(Class type) {
		    return true;
		}

		@Override
		public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {

		    @SuppressWarnings("unchecked")
		    java.util.List<String> list = (java.util.List<String>)source;

		    for (String string : list) {
		        writer.startNode(alias);
		        writer.setValue(string);
		        writer.endNode();
		    }

		}

		@Override
		public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		    throw new UnsupportedOperationException("ListToStringXStreamConverter does not offer suport for unmarshal operation");
		}

		}
}