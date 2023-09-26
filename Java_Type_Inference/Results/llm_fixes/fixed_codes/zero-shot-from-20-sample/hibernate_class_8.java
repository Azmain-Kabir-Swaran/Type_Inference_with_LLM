import javax.persistence.Temporal;
import javax.persistence.Column;
import java.util.Date;
import javax.validation.constraints.AssertTrue;
import javax.persistence.TemporalType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.persistence.Transient;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class hibernate_class_8 {
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

    @javax.validation.constraints.AssertTrue(message = "Dates are not valid the thru date must be empty, or after the fromdate.")
    public boolean areDatesValid() {
        if (thru == null) {
            return true;
        } else {
            return thru.after(from);
        }
    }

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
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