package xstream;
import java.io.StringWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.XStream;
//ID=2008043


public class xstream_class_10 {
	private String generateResponse(final XStream xStream)
	{
	    StringWriter writer = new StringWriter();
	    xStream.marshal(this, new PrettyPrintWriter(writer) {
	        @Override
	        public void addAttribute(final String key, final String value)
	        {
	            if (!key.equals("class"))
	            {
	                super.addAttribute(key, value);
	            }
	        }
	    });
	    return writer.toString();
	}
}