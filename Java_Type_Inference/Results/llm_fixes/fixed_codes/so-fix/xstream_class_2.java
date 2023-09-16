import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class xstream_class_2 {
    public static void main(String arg[]) throws IOException {
        XStream xstream = new XStream(new Dom4JDriver());
        FileReader fin = new FileReader("path_to_file.xml");
        BufferedReader br = new BufferedReader(fin);

        String str = "";
        String line;
        while ((line = br.readLine()) != null) {
            str += line + "\n";
        }
    }
}