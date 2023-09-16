import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.mapper.MapperWrapper;

public class xstream_class_14 {
    public static class SingleValueEnumConverter implements SingleValueConverter {
        private final Class<?> enumType;

        public SingleValueEnumConverter(Class<?> type) {
            this.enumType = type;
        }

        public boolean canConvert(Class type) {
            return enumType.isAssignableFrom(type) && type.getEnumConstants() != null;
        }

        public String toString(Object o) {
            return ((Enum<?>) o).name();
        }

        public Object fromString(String s) {
            return Enum.valueOf((Class<Enum>) enumType, s);
        }
    }
}

public class EnumMapper extends MapperWrapper {

    public EnumMapper(Mapper wrapped) {
        super(wrapped);
    }

    public SingleValueConverter getLocalConverter(Class type) {
        if (type.isEnum()) {
            return new xstream_class_14.SingleValueEnumConverter(type);
        }
        return super.getLocalConverter(type);
    }
}