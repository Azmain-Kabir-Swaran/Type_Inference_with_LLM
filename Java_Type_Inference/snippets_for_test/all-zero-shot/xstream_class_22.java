package xstream;
import java.util.Arrays;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.List;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;
//Id=17616142


@XStreamAlias("container")
public class xstream_class_22 {
  private String name;

  // any element named numberOfEmployees should go into this list
  @XStreamImplicit(itemFieldName="numberOfEmployees")
  protected List<NumberOfPersonnel> numberOfEmployees;

  public xstream_class_22(String name, List<NumberOfPersonnel> noEmp) {
    this.name = name;
    this.numberOfEmployees = noEmp;
  }

  public String toString() {
    return name + ", " + numberOfEmployees;
  }

  public static void main(String[] args) throws Exception {
    XStream xs = new XStream();
    xs.processAnnotations(xstream_class_22.class);

    System.out.println("Unmarshalling:");
    System.out.println(xs.fromXML(new File("in.xml")));

    System.out.println("Marshalling:");
    System.out.println(xs.toXML(new xstream_class_22("World",
           Arrays.asList(new NumberOfPersonnel(2001, 1000),
                         new NumberOfPersonnel(2002, 500)))));
  }
  @XStreamConverter(value = ToAttributedValueConverter.class, strings = {"value"})
  public static class NumberOfPersonnel {
    public NumberOfPersonnel(int year, double value) {
      this.year = year;
      this.value = value;
    }

    private int year;

    private double value;

    public String toString() {
      return year + ": " + value;
    }
  }
}