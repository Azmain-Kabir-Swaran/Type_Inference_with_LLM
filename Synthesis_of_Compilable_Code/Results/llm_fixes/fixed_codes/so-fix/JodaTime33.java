import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

public class JodaTime33 {

    public static void main(String[] args) {
        PeriodFormatter hoursMinutesSeconds = new PeriodFormatterBuilder()
                .appendHours().appendSuffix(" hour", " hours")
                .appendSeparator(", ", " and ")
                .appendMinutes()
                .appendSuffix(" minute", " minutes")
                .appendSeparator(" and ")
                .printZeroRarelyFirst()
                .appendSeconds()
                .appendSuffix(" second", " seconds")
                .toFormatter();

        System.out.println(hoursMinutesSeconds.print(new Period(0, 0, 0, 500)));
    }

}