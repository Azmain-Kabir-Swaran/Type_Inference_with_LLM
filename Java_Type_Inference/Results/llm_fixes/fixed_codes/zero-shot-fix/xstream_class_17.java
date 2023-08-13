import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.MarshallingContext;

public final class xstream_class_17 {
    public static void main(String[] args) {
        XStream xstream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
        xstream.autodetectAnnotations(true);
        
        final Position position = new Position();
        position.title = "The Title";
        position.startDate = "The Start Date";
        position.endDate = "The End Date";

        final String xml = xstream.toXML(position);
        System.out.println("Generated XML:");
        System.out.println(xml);

        final Position genPosition = (Position) xstream.fromXML(xml);
        System.out.println("Generated Position:");
        System.out.println("\tTitle: " + genPosition.title);
        System.out.println("\tStart Date: " + genPosition.startDate);
        System.out.println("\tEnd Date: " + genPosition.endDate);
    }
    
    @XStreamAlias("Position")
    @XStreamConverter(PositionConverter.class)
    private static class Position {
        private String title;
        private String startDate;
        private String endDate;

        // Getter and Setter methods
    }

    private static class PositionConverter implements Converter {
        
        public boolean canConvert(Class clazz) {
            return Position.class == clazz;
        }

        public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
            Position position = (Position) value;
            writer.startNode("Position");

            writer.startNode("Title");
            writer.setValue(position.title);
            writer.endNode();

            writer.startNode("StartDate");
            writer.setValue(position.startDate);
            writer.endNode();

            writer.startNode("EndDate");
            writer.setValue(position.endDate);
            writer.endNode();

            writer.endNode();
        }

        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            Position position = new Position();
            reader.moveDown();
            String title = reader.getValue();
            position.title = title;
            reader.moveUp(); 
            
            reader.moveDown();
            String startDate = reader.getValue();
            position.startDate = startDate;
            reader.moveUp(); 

            reader.moveDown(); 
            String endDate = reader.getValue();
            position.endDate = endDate;
            reader.moveUp(); 

            return position;
        }
    }
}