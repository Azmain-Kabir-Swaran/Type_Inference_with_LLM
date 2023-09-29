import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.MarshallingContext;
import com.thoughtworks.xstream.io.xml.UnmarshallingContext;

public final class xstream_class_17 {
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
        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        private String title;
        private String startDate;
        private String endDate;
    }

    private static class PositionConverter implements Converter {
        public boolean canConvert(Class<?> clazz) {
            return Position.class == clazz;
        }
