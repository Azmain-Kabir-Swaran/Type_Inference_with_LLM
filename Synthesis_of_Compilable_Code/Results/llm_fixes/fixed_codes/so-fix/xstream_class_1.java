import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.MarshallingContext;

public class xstream_class_1 implements Converter {
	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {

	    while (reader.hasMoreChildren()) {
	        reader.moveDown();
	        String a;
			if (reader.getNodeName().equals("a")) {
	            a = reader.getValue();
	        } else if (reader.getNodeName().equals("b")) {
	            Object b = (Object) context.convertAnother(reader, Object.class);
	        } else if (reader.getNodeName().equals("c")) {
	            a = reader.getValue();
	        }

	    }
		return context;
	}

	@Override
	public boolean canConvert(Class type) {
		return false;
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		
	}
}