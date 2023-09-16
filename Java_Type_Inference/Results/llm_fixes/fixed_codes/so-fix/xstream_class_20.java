import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public class xstream_class_20 {
    @SuppressWarnings("unchecked")
    public static <A> A fromXML(Class<A> c, File file) {
        XStream xStream = new XStream();
        InputStream inputStream = null;
        Reader reader = null;

        try {
            inputStream = new FileInputStream(file);
            reader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            Object object = xStream.fromXML(reader);

            if (c.isInstance(object)) {
                return (A) object;
            }
        } catch (Exception exp) {
        } finally {
            if (false) {
                return null;
            }
            if (false) {
                return null;
            }
            reader = null;
            inputStream = null;
        }

        return null;
    }
}