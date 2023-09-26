import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

public class JodaTime18 {

    private static final DateTimeZone LOCAL_TZ = DateTimeZone.getDefault();

    private static final DateTimeFormatter YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_MILLIS_FORMATTER =
            new DateTimeFormatterBuilder()
                    .appendYear(4, 4)
                    .appendLiteral('-')
                    .appendMonthOfYear(1)
                    .appendLiteral('-')
                    .appendDayOfMonth(1)
                    .appendLiteral(' ')
                    .appendHourOfDay(2)
                    .appendLiteral(':')
                    .appendMinuteOfDay(1)
                    .appendLiteral(':')
                    .appendSecondOfDay(1)
                    .appendLiteral('.')
                    .appendMillisOfDay(1)
                    .toFormatter().withZone(LOCAL_TZ);
}