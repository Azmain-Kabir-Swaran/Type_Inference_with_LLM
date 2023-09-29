import java.util.Map;
import java.util.HashMap;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class xstream_class_36 {
    public class MapTest {
        private Map<String, String> mapList;

        public MapTest() {
            mapList = new HashMap<String, String>();
        }

        public void setServicesHealth(String id, String name) {
            mapList.put(id, name);
        }
    }

    public static void main(String arg[]) {
        xstream_class_36.MapTest services = null;
        services.setServicesHealth("ID01", "Jack");
        services.setServicesHealth("ID02", "Neil");

        XStream stream = new XStream(new StaxDriver());
        stream.alias("MapTest", xstream_class_36.MapTest.class);
        stream.addImplicitMap(xstream_class_36.MapTest.class, "map", "id", String.class, "name");
        String xmlStr = stream.toXML(services);
        System.out.println(xmlStr);
    }
}