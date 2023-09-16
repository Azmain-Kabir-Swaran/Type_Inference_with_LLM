package jodatime;

import org.joda.time.DateTime;
import org.joda.time.Interval;

public class JodaTime19 {
    public static void main(String[] args) {
        DateTime now = DateTime.now();
        Interval i2 = new Interval(now, now.plusMillis(1000));
        Interval i1 = new Interval(now.minusMillis(1000), now.plusMillis(2000));
        boolean overlapping = i2.overlaps(i1);
    }
}