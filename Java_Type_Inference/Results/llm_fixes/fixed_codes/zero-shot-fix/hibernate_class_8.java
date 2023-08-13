import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class HibernateClass8 {
    private static final long serialVersionUID = 1L;

    private Date fromDate;
    private Date thruDate;

    @Transient
    public boolean isActive() {
        Date now = new Date();
        boolean afterFrom = fromDate.before(now) || fromDate.equals(now);
        boolean beforeThru = thruDate == null || thruDate.after(now) || thruDate.equals(now);
        return afterFrom && beforeThru;
    }

    @AssertTrue(message = "Dates are not valid. The thru date must be empty or after the fromDate.")
    public boolean areDatesValid() {
        if (thruDate == null) {
            return true;
        } else {
            return thruDate.after(fromDate);
        }
    }

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "From date must not be null")
    @Column(name = "fromDate")
    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getThruDate() {
        return thruDate;
    }

    public void setThruDate(Date thruDate) {
        this.thruDate = thruDate;
    }
}