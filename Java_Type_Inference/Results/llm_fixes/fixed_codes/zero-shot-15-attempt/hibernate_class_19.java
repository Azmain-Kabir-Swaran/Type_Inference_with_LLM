import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Index;

@Entity
@Table(name = "hibernate_class_19",
    indexes = {
        @Index(name = "IDX_XDN_DFN",
            columnList = "XDN, DFN"
        )
    })
public class hibernate_class_19 {
    public static final String TABLE_NAME = "hibernate_class_19";
    public static final String XDN = "XDN";
    public static final String DFN = "DFN";
    
    // class body
}