import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import com.thoughtworks.xstream.XStream;

public class xstream_class_44 { 
	public static int COUNT = 0; 
	public static int MAX_DEPTH = 800; 
	
	public static void main(String[] args) { 
		try { 
			TestObject object = getNewTestObject(); 
			File persistFile = new File("C:\\ABC.xml"); 
			FileOutputStream outStream = new FileOutputStream(persistFile); 
			XStream x = new XStream(); 
			x.alias("testObject", TestObject.class); 
			x.toXML(object, outStream); 
			outStream.close(); 
		} catch (Throwable e) { 
			e.printStackTrace(); 
		} 
	} 
	
	public static TestObject getNewTestObject() { 
		TestObject orderRecord = new TestObject();
		orderRecord.setName("OBJECT_" + COUNT); 
		while (COUNT++ < MAX_DEPTH) { 
			orderRecord.setParentObject(getNewTestObject()); 
		} 
		return orderRecord; 
	} 
	
	public static class TestObject { 
		private TestObject parentObject; 
		private String name; 
		
		public TestObject getParentObject() { 
			return parentObject; 
		} 
		
		public void setParentObject(TestObject parentObject) { 
			this.parentObject = parentObject; 
		} 
		
		public String getName() { 
			return name; 
		} 
		
		public void setName(String name) { 
			this.name = name; 
		} 
	} 
}