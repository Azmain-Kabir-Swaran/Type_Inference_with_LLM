import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.converters.javabean.JavaBeanConverter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class xstream_class_23 {

    @XStreamAlias("test")
    public static class TestObject {
        private String foo;

        public String getFoo() {
            return foo.toLowerCase();
        }

        public void setFoo(String foo) {
            this.foo = foo;
        }
    }

    public static void main(String[] args) throws Exception {
        XStream x = new XStream(new XppDriver());
        x.autodetectAnnotations(true);
        x.processAnnotations(TestObject.class);

        x.registerConverter(new JavaBeanConverter(x.getMapper()));

        TestObject o = new TestObject();
        o.setFoo("BAR");

        String xml = x.toXML(o);

        System.out.println(xml);
    }
}