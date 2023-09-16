import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public final class XStreamExample {
    public static void main(String[] args) {
        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        xstream.registerConverter(new PositionConverter());

        final Position position = new Position();
        position.setTitle("The Title");
        position.setStartDate("The Start Date");
        position.setEndDate("The End Date");

        final String xml = xstream.toXML(position);
        System.out.println("Generated XML:");
        System.out.println(xml);

        final Position genPosition = (Position) xstream.fromXML(xml);
        System.out.println("Generated Position:");
        System.out.println("\tTitle: " + genPosition.getTitle());
        System.out.println("\tStart Date: " + genPosition.getStartDate());
        System.out.println("\tEnd Date: " + genPosition.getEndDate());
    }

    @XStreamAlias("Position")
    private static class Position {
        private String title;
        private String startDate;
        private String endDate;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }
    }

    private static class PositionConverter implements Converter {
        public boolean canConvert(Class<?> clazz) {
            return Position.class.isAssignableFrom(clazz);
        }

        public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
            Position position = (Position) value;
            writer.startNode("Position");

            writer.startNode("Title");
            writer.setValue(position.getTitle());
            writer.endNode();

            writer.startNode("StartDate");
            writer.setValue(position.getStartDate());
            writer.endNode();

            writer.startNode("EndDate");
            writer.setValue(position.getEndDate());
            writer.endNode();

            writer.endNode();
        }

        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            Position position = new Position();
            reader.moveDown(); // move down to <Title> tag
            String title = reader.getValue();
            position.setTitle(title);
            reader.moveUp(); // move back to <Position>

            reader.moveDown(); // move down to <StartDate> tag
            String startDate = reader.getValue();
            position.setStartDate(startDate);
            reader.moveUp(); // move back to <Position>

            reader.moveDown(); // move down to <EndDate> tag
            String endDate = reader.getValue();
            position.setEndDate(endDate);
            reader.moveUp(); // move back to <Position>

            return position;
        }
    }
}