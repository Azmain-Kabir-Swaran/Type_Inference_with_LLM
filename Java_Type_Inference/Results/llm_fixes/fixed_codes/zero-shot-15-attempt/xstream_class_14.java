import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.ConverterMatcher;
import com.thoughtworks.xstream.converters.enums.EnumSingleValueConverter;

public class xstream_class_14 {
    public class SingleValueEnumConverter implements SingleValueConverter, ConverterMatcher {
        private final Class<?> enumType;

        public SingleValueEnumConverter(Class<?> type) {
            this.enumType = type;
        }

        public boolean canConvert(Class<?> c) {
            return c.equals(enumType);
        }

        public Object fromString(String value) {
            return EnumSingleValueConverter.valueOf(enumType, value);
        }

        public String toString(Object obj) {
            return obj.toString();
        }

        public Class<?> getEnumType() {
            return enumType;
        }
    }
}