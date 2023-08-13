package xstream;

import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;

import java.util.ArrayList;

public class xstream_class_37 {
    public static class FieldDtoConvertor implements Converter {

        @Override
        public boolean canConvert(Class clazz) {
            return clazz.equals(FieldDto.class);
        }

        @Override
        public void marshal(final Object value,
                            final HierarchicalStreamWriter writer,
                            final MarshallingContext context) {
            final FieldDto fieldDto = (FieldDto) value;
            for (int i = 0; i < fieldDto.getSize(); i++) {
                writer.addAttribute(fieldDto.getAttributeName(i), fieldDto.getAttributeValue(i));
            }
            writer.setValue(fieldDto.getText());
        }

        @Override
        public Object unmarshal(HierarchicalStreamReader reader,
                               UnmarshallingContext context) {
            FieldDto fieldDto = new FieldDto();
            for (int i = 0; i < reader.getAttributeCount(); i++) {
                fieldDto.addAttribute(reader.getAttributeName(i), reader.getAttribute(i));
            }
            fieldDto.setText(reader.getValue());
            return fieldDto;
        }
    }

    public static class FieldDto {
        private ArrayList<String> attributeName;
        private ArrayList<String> attributeValue;
        private String text;

        public FieldDto() {
            attributeName = new ArrayList<>();
            attributeValue = new ArrayList<>();
        }

        public String getAttributeName(int index) {
            return attributeName.get(index);
        }

        public void addAttribute(String attributeName, String attributeValue) {
            this.attributeName.add(attributeName);
            this.attributeValue.add(attributeValue);
        }

        public String getAttributeValue(int index) {
            return attributeValue.get(index);
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getSize() {
            return attributeName.size();
        }
    }
}