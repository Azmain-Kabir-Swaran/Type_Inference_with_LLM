package jodatime;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTime;

public class JodaTime48 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    private final DateTimeUtils.MillisProvider millisProvider;
    private final DateTime someDate;

    public JodaTime48(DateTimeUtils.MillisProvider millisProvider, DateTime someDate) {
        this.millisProvider = millisProvider;
        this.someDate = someDate;
    }

    public boolean isAvailable() {
        long now = millisProvider.getMillis();
        return (someDate.isBefore(now));
    }
}