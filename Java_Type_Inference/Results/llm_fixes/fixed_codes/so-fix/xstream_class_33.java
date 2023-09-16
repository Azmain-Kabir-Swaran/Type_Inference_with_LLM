import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class xstream_class_33 {
	private static XStream xstream; 
	public static XStream getXStream() {
		if (xstream == null) {
			xstream = new XStream(new DomDriver());

			xstream.alias("ActionMessage", com.package1.ActionMessage.class);
			xstream.alias("MessageHeader", com.package2.MessageHeader.class);
			xstream.alias("MessageBody", com.package2.MessageBody.class);
			xstream.alias("RemotingMessage", com.package3.RemotingMessage.class);
			xstream.alias("CommandMessage", com.package1.CommandMessage.class);
			xstream.alias("AcknowledgeMessage", com.package1.AcknowledgeMessage.class);
			xstream.alias("ErrorMessage", com.package1.ErrorMessage.class);
			xstream.alias("ASObject", com.package4.ASObject.class);
			xstream.alias("AsyncMessage", com.package5.AsyncMessage.class);
			xstream.alias("DSC", com.package1.CommandMessageExt.class);
			xstream.alias("DSK", com.package1.AcknowledgeMessageExt.class);
		}

		return xstream;
	}
}