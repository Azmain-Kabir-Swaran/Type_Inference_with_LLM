import org.joda.time.Instant;
import org.joda.time.Period;

public class JodaTime04 {
    private Instant[] startTime;
    private Instant[] endTime;

    public String foobar(int dayIndex) {
        Period p = new Period(this.startTime[dayIndex], this.endTime[dayIndex]);
        long hours = p.getHours();
        long minutes = p.getMinutes();

        String format = String.format("%%0%dd", 2);

        return Long.toString(hours) + ":" + String.format(format, minutes);
    }
}