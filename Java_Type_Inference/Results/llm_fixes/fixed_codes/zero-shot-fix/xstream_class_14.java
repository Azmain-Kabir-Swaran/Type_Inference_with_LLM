package xstream;

import com.thoughtworks.xstream.converters.SingleValueConverter;

public class xstream_class_14 {
    public static class SingleValueEnumConverter implements SingleValueConverter {
        private final Class<? extends Enum<?>> enumType;

        public SingleValueEnumConverter(Class<? extends Enum<?>> type) {
            this.enumType = type;
        }

        public boolean canConvert(Class<?> c) {
            return enumType.isAssignableFrom(c);
        }

        public String toString(Object value) {
            return ((Enum<?>) value).name();
        }

        public Object fromString(String value) {
            return Enum.valueOf(enumType.asSubclass(Enum.class), value);
        }

        @SuppressWarnings("rawtypes")
        public Class<? extends Enum<?>> getEnumType() {
            return enumType;
        }
    }
}