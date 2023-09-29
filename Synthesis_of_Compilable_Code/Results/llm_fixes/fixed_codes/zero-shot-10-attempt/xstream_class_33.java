package xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class xstream_class_33 {
    private static XStream xstream; 
    public static XStream getXStream() {
        if (xstream == null) {
            xstream = new XStream(new DomDriver());

            xstream.alias("ActionMessage", xstream_class_33.ActionMessage.class);
            xstream.alias("MessageHeader", xstream_class_33.MessageHeader.class);
            xstream.alias("MessageBody", xstream_class_33.MessageBody.class);
            xstream.alias("RemotingMessage", xstream_class_33.RemotingMessage.class);
            xstream.alias("CommandMessage", xstream_class_33.CommandMessage.class);
            xstream.alias("AcknowledgeMessage", xstream_class_33.AcknowledgeMessage.class);
            xstream.alias("ErrorMessage", xstream_class_33.ErrorMessage.class);
            xstream.alias("ASObject", xstream_class_33.ASObject.class);
            xstream.alias("AsyncMessage", xstream_class_33.AsyncMessage.class);
            xstream.alias("DSC", xstream_class_33.CommandMessageExt.class);
            xstream.alias("DSK", xstream_class_33.AcknowledgeMessageExt.class);
        }

        return xstream;
    }

    public static class ActionMessage {}
    public static class MessageHeader {}
    public static class MessageBody {}
    public static class RemotingMessage {}
    public static class CommandMessage {}
    public static class AcknowledgeMessage {}
    public static class ErrorMessage {}
    public static class ASObject {}
    public static class AsyncMessage {}
    public static class CommandMessageExt {}
    public static class AcknowledgeMessageExt {}
}