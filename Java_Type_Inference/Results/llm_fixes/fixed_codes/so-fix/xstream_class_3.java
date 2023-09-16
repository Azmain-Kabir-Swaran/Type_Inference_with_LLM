import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import java.util.ArrayList;
import java.util.List;

public class xstream_class_3 {
    public static void main(String[] args) {
        JettisonMappedXmlDriver xmlDriver = new JettisonMappedXmlDriver();
        XStream xstream = new XStream(xmlDriver);

        List<Object> messages = new ArrayList<>();
        Object mock1 = null;
        messages.add(mock1);
        Object mock2 = null;
        messages.add(mock2);
        Object mock3 = null;
        messages.add(mock3);

        String jsonString = xstream.toXML(messages);
        System.out.println(jsonString);

        List<Object> xstreamJSONUnmarshalledMessages = (List<Object>)xstream.fromXML(jsonString);
        System.out.println("XStream format JSON Number of messages unmarshalled: " + xstreamJSONUnmarshalledMessages.size());

        String jsonTest = 
              "{"+
                "\"list\" : ["+ 
                          "{"+
                          "\"MockMessage\" : {"+
                              "\"val\" : 1"+
                          "}"+
                      "}, {"+
                          "\"MockMessage\" : {"+
                              "\"val\" : 1"+
                          "}"+
                      "}, {"+
                          "\"MockMessageOther\" : {"+
                              "\"otherVal\" : 1"+
                          "}"+
                      "} ]"+
                  "}";

        List<Object> unmarshalledMessages = (List<Object>)xstream.fromXML(jsonTest);
        System.out.println("Normal format JSON Number of messages unmarshalled: " + unmarshalledMessages.size());
    }
}