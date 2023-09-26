package xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.example.ActionMessage;
import com.example.MessageHeader;
import com.example.MessageBody;
import com.example.RemotingMessage;
import com.example.CommandMessage;
import com.example.AcknowledgeMessage;
import com.example.ErrorMessage;
import com.example.ASObject;
import com.example.AsyncMessage;
import com.example.CommandMessageExt;
import com.example.AcknowledgeMessageExt;

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
        }

        return xstream;
    }
}