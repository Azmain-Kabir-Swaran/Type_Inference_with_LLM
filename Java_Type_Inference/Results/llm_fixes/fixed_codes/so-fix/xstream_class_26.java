import com.thoughtworks.xstream.converters.SingleValueConverter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class xstream_class_26 {
    public static class IntegerListConverter implements SingleValueConverter {
        public boolean canConvert(Class type) {
            return List.class.isAssignableFrom(type);
        }

        public Object fromString(String str) {
            Collection<Integer> collection = new ArrayList<>();
            String[] integerStrings = str.split(" ");
            for (String integerString : integerStrings) {
                collection.add(Integer.valueOf(integerString));
            }
            return collection;
        }

        public String toString(Object obj) {
            List<?> collection = (List<?>) obj;
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (Object object : collection) {
                if (first) {
                    first = false;
                } else {
                    sb.append(' ');
                }
                sb.append(object.toString());
            }
            return sb.toString();
        }
    }
}