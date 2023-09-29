package jodatime;

import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;

public class JodaTime48 {

    private final ReadableInstant millisProvider;
    private final DateTime someDate;

    public JodaTime48(ReadableInstant millisProvider, DateTime someDate) {
        this.millisProvider = millisProvider;
        this.someDate = someDate;
    }

    public boolean isAvailable() {
        long now = millisProvider.getMillis();
        return (someDate.isBefore(now));
    }
}