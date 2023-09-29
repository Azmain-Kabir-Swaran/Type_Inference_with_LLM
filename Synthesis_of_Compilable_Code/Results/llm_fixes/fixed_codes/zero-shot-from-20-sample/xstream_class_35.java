import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.thoughtworks.xstream.mapper.DefaultReflectionProvider;

public class xstream_class_35 { 
    
   public static class AClass{ 
       public String value = "This should be in an attribute"; 
       public CompositeClass  anotherValue = new CompositeClass(); 
   } 
    
   public static class CompositeClass { 
       public Integer value = 42; 
   } 
    
   public static class ToSingleValue implements SingleValueConverter{ 

       public boolean canConvert(Class<?> type) { 
           return CompositeClass.class == type; 
       } 

       public String toString(Object obj) { 
           CompositeClass cCompositeClass = (CompositeClass)obj; 
           return cCompositeClass.value.toString(); 
       } 

       public Object fromString(String str) { 
           return new CompositeClass(); 
       } 
        
   } 
    
   @org.junit.Test 
   public void testName() throws Exception { 
       XStream xStream = new XStream(); 
       xStream.registerConverter(new ToSingleValue()); 
        
       Mapper mapper = xStream.getMapper(); 
       DefaultReflectionProvider reflectionProvider = new DefaultReflectionProvider();
       ConverterLookup converterLookup = xStream.getConverterLookup(); 
       String valueField = null; 
       Converter converter = null;
       xStream.registerConverter(converter); 
       System.out.println(xStream.toXML(new AClass())); 
   } 
    
   protected MapperWrapper wrapMapper(MapperWrapper next) { 
       return next; 
   } 
}