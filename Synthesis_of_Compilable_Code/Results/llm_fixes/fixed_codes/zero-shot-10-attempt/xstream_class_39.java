package xstream;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.XStream;
import java.io.Writer;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class xstream_class_39 {

	private static XStream xstream = new XStream(new XppDriver() {
	        @Override
	        public HierarchicalStreamWriter createWriter(Writer out) {  
	            return new PrettyPrintWriter(out) {  
	                // Add CDATA block  
	                boolean cdata;//I need to add cdata for some fields only  
	                boolean isNeedUpper;//only some will need this

	                protected void writeText(HierarchicalStreamWriter writer, String text) {  
	                    if (cdata) {  
	                        writer.startNode("<![CDATA[");  
	                        writer.setValue(text);  
	                        writer.endNode();  
	                    } else if (isNeedUpper){  
	                        writer.setValue(text.toUpperCase());  
	                    }  
	                    else writer.setValue(text);
	                }  
	            };  
	        }  
	    });
}