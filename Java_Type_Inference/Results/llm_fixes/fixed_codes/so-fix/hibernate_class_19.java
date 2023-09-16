@Entity
@Table(name = "house", indexes = {
        @Index(name = "IDX_XDN_DFN",
                columnList = "xdn, dfn")
})
public class HibernateClass19 {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "xdn")
    private long xdn;

    @Column(name = "dfn")
    private long dfn;

    @Column(name = "address")
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