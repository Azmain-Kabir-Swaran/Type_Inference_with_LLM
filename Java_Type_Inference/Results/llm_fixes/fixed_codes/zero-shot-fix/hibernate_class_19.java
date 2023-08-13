package hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Index;
import javax.persistence.Column;
import org.hibernate.annotations.Table;

@Entity
@Table(name = HibernateClass19.TABLE_NAME,
        indexes = {
                @Index(name = "IDX_XDN_DFN", columnList = HibernateClass19.XDN + ", " + HibernateClass19.DFN)
        }
)
public class HibernateClass19 {
    public final static String TABLE_NAME = "house";
    public final static String XDN = "xdn";
    public final static String DFN = "dfn";

    @Id
    @GeneratedValue
    private long id;

    @Column(name = XDN)
    private long xdn;

    @Column(name = DFN)
    private long dfn;

    @Column
    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getXdn() {
        return xdn;
    }

    public void setXdn(long xdn) {
        this.xdn = xdn;
    }

    public long getDfn() {
        return dfn;
    }

    public void setDfn(long dfn) {
        this.dfn = dfn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}