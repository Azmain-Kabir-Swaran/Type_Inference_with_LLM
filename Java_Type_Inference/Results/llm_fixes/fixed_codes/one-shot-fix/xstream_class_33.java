package xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.io.xml.DomDriver;
import flex.messaging.io.amf.*;

public class XStreamClass {
    private static XStream xstream;

    public static XStream getXStream() {
        if (xstream == null) {
            xstream = new XStream(new DomDriver());

            xstream.alias("ActionMessage", ActionMessage.class);
            xstream.alias("MessageHeader", MessageHeader.class);
            xstream.alias("MessageBody", MessageBody.class);
            xstream.alias("flex.messaging.io.amf.remoting.RemotingMessage", RemotingMessage.class);
            xstream.alias("flex.messaging.messages.CommandMessage", CommandMessage.class);
            xstream.alias("flex.messaging.messages.AcknowledgeMessage", AcknowledgeMessage.class);
            xstream.alias("flex.messaging.messages.ErrorMessage", ErrorMessage.class);
            xstream.alias("flex.messaging.io.amf.ASObject", ASObject.class);
            xstream.alias("flex.messaging.messages.AsyncMessage", AsyncMessage.class);
            xstream.alias("flex.messaging.io.amf.ActionMessageExt", CommandMessageExt.class);
            xstream.alias("flex.messaging.io.amf.AcknowledgeMessageExt", AcknowledgeMessageExt.class);

            // Better ASObject Converter
            Mapper mapper = xstream.getMapper();
        }

        return xstream;
    }
}