package xstream;

import com.thoughtworks.xstream.converters.SingleValueConverter;

public class xstream_class_14 {
    public class SingleValueEnumConverter implements SingleValueConverter {
        @SuppressWarnings("rawtypes")
        private final Class enumType;

        public SingleValueEnumConverter(Class type) {
            this.enumType = type;
        }

        public boolean canConvert(Class c) {
            return c.equals(enumType);
        }

        public String toString(Object obj) {
            return obj.toString();
        }

        public Object fromString(String value) {
            return Enum.valueOf(enumType, value);
        }

        public boolean canConvert(Class type, Object obj) {
            return canConvert(type);
        }
    }
}