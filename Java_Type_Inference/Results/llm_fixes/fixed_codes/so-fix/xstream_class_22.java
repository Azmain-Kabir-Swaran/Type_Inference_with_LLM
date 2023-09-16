import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;
import java.io.File;
import java.util.List;

@XStreamAlias("container")
public class xstream_class_22 {
  private String name;

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
    System.out.println();
  }

  @XStreamConverter(value = ToAttributedValueConverter.class, strings = {"value"})
  public class NumberOfPersonnel {
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