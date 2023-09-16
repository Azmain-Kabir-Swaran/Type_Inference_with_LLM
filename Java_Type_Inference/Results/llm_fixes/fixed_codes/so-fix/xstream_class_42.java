import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.List;

public class xstream_class_42 {
    @XStreamAlias("addressServiceConfig")
    public static class AddressServiceConfig {
        private String pathToCodeposFiles;
        @XStreamImplicit(itemFieldName = "region")
        private List<Region> regions;
    }

    @XStreamAlias("region")
    public static class Region {
        private String regionName;
        @XStreamImplicit(itemFieldName = "province")
        private List<Province> provinces;
    }

    @XStreamAlias("province")
    public static class Province {
        private int code;
        private String name;
    }
}