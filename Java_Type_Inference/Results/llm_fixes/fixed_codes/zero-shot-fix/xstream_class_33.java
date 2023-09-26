import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import xstream.ActionMessage;
import xstream.MessageHeader;
import xstream.MessageBody;
import xstream.RemotingMessage;
import xstream.CommandMessage;
import xstream.AcknowledgeMessage;
import xstream.ErrorMessage;
import xstream.ASObject;
import xstream.AsyncMessage;
import xstream.CommandMessageExt;
import xstream.AcknowledgeMessageExt;
import com.thoughtworks.xstream.mapper.Mapper;

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

            Mapper mapper = xstream.getMapper();
        }

        return xstream;
    }
}