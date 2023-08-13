package xstream;
import flex.messaging.io.amf.AsyncMessage;
import flex.messaging.io.amf.CommandMessage;
import com.thoughtworks.xstream.XStream;
import flex.messaging.io.amf.ErrorMessage;
import flex.messaging.io.amf.AcknowledgeMessage;
import flex.messaging.io.amf.AcknowledgeMessageExt;
import flex.messaging.io.amf.CommandMessageExt;
import flex.messaging.io.amf.ActionMessage;
import flex.messaging.io.amf.ASObject;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.io.xml.DomDriver;
import flex.messaging.io.amf.MessageHeader;
import flex.messaging.io.amf.MessageBody;
import flex.messaging.io.amf.RemotingMessage;
//http://www.programcreek.com/java-api-examples/index.php?api=com.thoughtworks.xstream.XStream



public class xstream_class_33 {
	private static XStream xstream; 
	public static XStream getXStream() {
		if (xstream == null) {
			xstream = new XStream(new DomDriver());

			xstream.alias("ActionMessage", ActionMessage.class);
			xstream.alias("MessageHeader", MessageHeader.class);
			xstream.alias("MessageBody", MessageBody.class);
			xstream.alias("RemotingMessage", RemotingMessage.class);
			xstream.alias("CommandMessage", CommandMessage.class);
			xstream.alias("AcknowledgeMessage", AcknowledgeMessage.class);
			xstream.alias("ErrorMessage", ErrorMessage.class);
			xstream.alias("ASObject", ASObject.class);
			xstream.alias("AsyncMessage", AsyncMessage.class);
			xstream.alias("DSC", CommandMessageExt.class);
			xstream.alias("DSK", AcknowledgeMessageExt.class);

			// Better ASObject Converter
			Mapper mapper = xstream.getMapper();
		}

		return xstream;
	}
}