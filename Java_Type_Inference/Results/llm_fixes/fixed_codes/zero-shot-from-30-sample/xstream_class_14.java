package xstream;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.enums.EnumSingleValueConverter;

public class xstream_class_14 {
	public class SingleValueEnumConverter implements SingleValueConverter
	{
	    @SuppressWarnings("rawtypes")
		private final Class enumType;

	    public SingleValueEnumConverter(Class type)
	    {
	        this.enumType = type;
	    }

	    public boolean canConvert(Class c)
	    {
	        return c.equals(enumType);
	    }

	    public Object fromString(String value)
	    {
	        return Enum.valueOf(enumType, value);
	    }

	    public String toString(Object obj)
	    {
	        return obj.toString();
	    }

	    @SuppressWarnings("rawtypes")
		public Class enumType()
	    {
	        return enumType;
	    }
	}
}