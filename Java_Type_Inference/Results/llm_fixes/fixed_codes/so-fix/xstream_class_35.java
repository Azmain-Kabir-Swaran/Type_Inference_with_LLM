import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import org.junit.Test;

public class xstream_class_35 {

    public static class AClass{
        public String value = "This should be in an attribute";
        public CompositeClass anotherValue = new CompositeClass();
    }

    public static class CompositeClass {
        public Integer value = 42;
    }

    public static class ToSingleValue implements SingleValueConverter{

        @Override
        public boolean canConvert(Class type) {
            return CompositeClass.class == type;
        }

        @Override
        public String toString(Object obj) {
            CompositeClass cCompositeClass = (CompositeClass)obj;
            return cCompositeClass.value.toString();
        }

        @Override
        public Object fromString(String str) {
            return new CompositeClass();
        }

    }

    @Test
    public void testName() throws Exception {
        XStream xStream = new XStream(new DomDriver());
        xStream.registerConverter(new ToSingleValue());

        MapperWrapper mapperWrapper = new MapperWrapper(xStream.getMapper()) {
                @Override
                public Converter getLocalConverter(Class definedIn, String fieldName) {
                    return super.getLocalConverter(definedIn, fieldName);
                }
            };

        ReflectionProvider reflectionProvider = xStream.getReflectionProvider();
        ConverterLookup converterLookup = xStream.getConverterLookup();
        Converter converter = null;
        xStream.registerConverter(converter);
        System.out.println(xStream.toXML(new AClass()));
    }
    
    protected MapperWrapper wrapMapper(MapperWrapper next) {
        return next;
    }
}