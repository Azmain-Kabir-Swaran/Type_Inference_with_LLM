import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

public class JodaTime44 {

    public static void main(String[] args) {
        PeriodFormatter daysHoursMinutes = new PeriodFormatterBuilder()
                .appendDays()
                .appendSuffix(" day", " days")
                .appendSeparator(" and ")
                .appendMinutes()
                .appendSuffix(" minute", " minutes")
                .appendSeparator(" and ")
                .appendSeconds()
                .appendSuffix(" second", " seconds")
                .toFormatter();

        Period period = Period.ZERO.plusDays(72).plusHours(24).plusMinutes(12);

        System.out.println(daysHoursMinutes.print(period));
        System.out.println(daysHoursMinutes.print(period.normalizedStandard()));
    }
}