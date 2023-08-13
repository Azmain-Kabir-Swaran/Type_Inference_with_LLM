package xstream;
import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import java.io.FileReader;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
//ID = 7491195
public class xstream_class_2 {
	public static  void main(String arg[]) throws IOException{
		XStream xstream = new XStream(new DomDriver()); 
		FileReader fin = new FileReader("path_to_file.xml"); 
		BufferedReader br = new BufferedReader(fin); 

		String str = null;
		while(br.ready())
		{ 
		  str += br.readLine() + "\n"; 
		} 

	}
}