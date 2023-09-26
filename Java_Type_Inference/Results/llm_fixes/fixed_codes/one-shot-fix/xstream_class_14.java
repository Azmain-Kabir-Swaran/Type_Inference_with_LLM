import com.thoughtworks.xstream.converters.ConverterMatcher;
import com.thoughtworks.xstream.converters.SingleValueConverter;

public class xstream_class_14 {
    public class SingleValueEnumConverter implements SingleValueConverter {
        private final Class<?> enumType;

        public SingleValueEnumConverter(Class<?> type) {
            this.enumType = type;
        }

        public boolean canConvert(Class<?> c) {
            return c.equals(enumType);
        }

        public Object fromString(String value) {
            return Enum.valueOf((Class<Enum>) enumType, value);
        }

        public String toString(Object obj) {
            return obj.toString();
        }
    }
}