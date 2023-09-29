package hibernate;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.Transient;

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
}