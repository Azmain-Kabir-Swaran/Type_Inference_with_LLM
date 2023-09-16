import org.joda.time.DateTime;

public class JodaTime48 {

    private final MillisProvider millisProvider;
    private final DateTime someDate;

    public JodaTime48(MillisProvider millisProvider, DateTime someDate) {
        this.millisProvider = millisProvider;
        this.someDate = someDate;
    }
    
    public boolean isAvailable() {
        long now = millisProvider.getMillis();
        return (someDate.isBefore(now));
    }
}

interface MillisProvider {
    long getMillis();
}