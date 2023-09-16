import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class HibernateClass8 {

    private static final long serialVersionUID = 1L;
    private Date from;
    private Date thru;

    @Transient
    public boolean isActive() {
        Date now = new Date();
        boolean afterFrom = from.before(now) || from.equals(now);
        boolean beforeThru = thru == null || thru.after(now) || thru.equals(now);
        return afterFrom && beforeThru;
    }

    public boolean areDatesValid() {
        if (thru == null) {
            return true;
        } else {
            return thru.after(from);
        }
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fromDate")
    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getThru() {
        return thru;
    }

    public void setThru(Date thru) {
        this.thru = thru;
    }
}