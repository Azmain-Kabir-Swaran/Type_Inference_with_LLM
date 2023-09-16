import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class JodaTime01 {

    public static void main(String[] args) {
        DateTimeFormatter timeParser = ISODateTimeFormat.timeParser();
        java.util.TimeZone timeZone = java.util.TimeZone.getDefault();
        System.out.println(timeZone.getID());
        System.out.println(timeZone.getDisplayName());

        DateTimeZone defaultTimeZone = DateTimeZone.getDefault();
        System.out.println(defaultTimeZone.getID());
        System.out.println(defaultTimeZone.getName(0L));

        DateTime currentTime = new DateTime();
        DateTimeZone currentZone = currentTime.getZone();
        System.out.println(currentZone.getID());
        System.out.println(currentZone.getName(0L));
    }
}