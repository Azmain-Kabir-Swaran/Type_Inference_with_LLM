import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import java.util.ArrayList;

public class xstream_class_37 {
    public static class FieldDtoConvertor implements Converter {

        public boolean canConvert(Class<?> clazz) {
            return clazz.equals(FieldDto.class);
        }

        public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
            final FieldDto fieldDto = (FieldDto) value;
            for (int i = 0; i < fieldDto.getAttributeName().size(); i++) {
                writer.addAttribute(fieldDto.getAttributeName().get(i), fieldDto.getAttributeValue().get(i));
            }
            writer.setValue(fieldDto.getText());
        }

        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            FieldDto fieldDto = new FieldDto();
            for (int i = 0; i < reader.getAttributeCount(); i++) {
                fieldDto.addAttribute(reader.getAttributeName(i), reader.getAttribute(i));
            }
            fieldDto.setText(reader.getValue());
            return fieldDto;
        }
    }

    public static class FieldDto {
        private ArrayList<String> attributeName = null;
        private ArrayList<String> attributeValue = null;
        private String text;

        public FieldDto() {
            attributeName = new ArrayList<String>();
            attributeValue = new ArrayList<String>();
        }

        public ArrayList<String> getAttributeName() {
            return attributeName;
        }

        public void addAttribute(String attributeName, String attributeValue) {
            this.attributeName.add(attributeName);
            this.attributeValue.add(attributeValue);
        }

        public ArrayList<String> getAttributeValue() {
            return attributeValue;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}