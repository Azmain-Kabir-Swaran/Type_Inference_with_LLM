package xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import flex.messaging.io.amf.ActionMessage;
import flex.messaging.io.amf.ASObject;
import flex.messaging.io.amf.MessageBody;
import flex.messaging.io.amf.MessageHeader;
import flex.messaging.io.amf.CommandMessage;
import flex.messaging.io.amf.AcknowledgeMessage;
import flex.messaging.io.amf.ErrorMessage;
import flex.messaging.io.amf.AsyncMessage;
import flex.messaging.io.amf.AcknowledgeMessageExt;
import flex.messaging.io.amf.CommandMessageExt;

public class xstream_class_33 {
    private static XStream xstream;

    public static XStream getXStream() {
        if (xstream == null) {
            xstream = new XStream(new DomDriver());

            xstream.alias("flex.messaging.io.amf.ActionMessage", ActionMessage.class);
            xstream.alias("flex.messaging.io.amf.MessageHeader", MessageHeader.class);
            xstream.alias("flex.messaging.io.amf.MessageBody", MessageBody.class);
            xstream.alias("flex.messaging.io.amf.CommandMessage", CommandMessage.class);
            xstream.alias("flex.messaging.io.amf.AcknowledgeMessage", AcknowledgeMessage.class);
            xstream.alias("flex.messaging.io.amf.ErrorMessage", ErrorMessage.class);
            xstream.alias("flex.messaging.io.amf.ASObject", ASObject.class);
            xstream.alias("flex.messaging.io.amf.AsyncMessage", AsyncMessage.class);
            xstream.alias("flex.messaging.io.amf.CommandMessageExt", CommandMessageExt.class);
            xstream.alias("flex.messaging.io.amf.AcknowledgeMessageExt", AcknowledgeMessageExt.class);
        }

        return xstream;
    }
}