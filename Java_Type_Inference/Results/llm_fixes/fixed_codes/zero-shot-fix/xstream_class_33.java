import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamUtil {
    private static XStream xstream;

    public static XStream getXStream() {
        if (xstream == null) {
            xstream = new XStream(new DomDriver());

            xstream.alias("ActionMessage", com.example.ActionMessage.class);
            xstream.alias("MessageHeader", com.example.MessageHeader.class);
            xstream.alias("MessageBody", com.example.MessageBody.class);
            xstream.alias("RemotingMessage", com.example.RemotingMessage.class);
            xstream.alias("CommandMessage", com.example.CommandMessage.class);
            xstream.alias("AcknowledgeMessage", com.example.AcknowledgeMessage.class);
            xstream.alias("ErrorMessage", com.example.ErrorMessage.class);
            xstream.alias("ASObject", com.example.ASObject.class);
            xstream.alias("AsyncMessage", com.example.AsyncMessage.class);
            xstream.alias("DSC", com.example.CommandMessageExt.class);
            xstream.alias("DSK", com.example.AcknowledgeMessageExt.class);
        }

        return xstream;
    }
}