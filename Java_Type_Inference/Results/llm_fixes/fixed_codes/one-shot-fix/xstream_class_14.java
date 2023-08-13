package xstream;

import com.thoughtworks.xstream.converters.SingleValueConverter;

public class xstream_class_14 {
    public static class SingleValueEnumConverter implements SingleValueConverter {
        private final Class<? extends Enum<?>> enumType;

        public SingleValueEnumConverter(Class<? extends Enum<?>> enumType) {
            this.enumType = enumType;
        }

        public boolean canConvert(Class<?> c) {
            return enumType.isAssignableFrom(c);
        }

        public String toString(Object obj) {
            return ((Enum<?>) obj).name();
        }

        public Object fromString(String value) {
            return Enum.valueOf(enumType, value);
        }

        @Override
        public String toString(Object obj) {
            return ((Enum<?>) obj).name();
        }

        @Override
        public Object fromString(String str) {
            Class<? extends Enum<?>> enumClass = (Class<? extends Enum<?>>) enumType;
            return Enum.valueOf(enumClass, str);
        }
    }
}