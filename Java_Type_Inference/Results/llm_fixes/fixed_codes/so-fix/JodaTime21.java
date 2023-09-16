import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;

public class JodaTime21 {
    public static void main(String[] args) {
        java.text.DateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date dt = null;
        try {
            dt = formatter.parse("2011-10-23 12:00:00");
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        LocalDateTime ldt = new DateTime(dt).withZone(DateTimeZone.UTC).toLocalDateTime();
        System.out.println("Original date: " + ldt.toDateTime().toDate().toString());
        DateTime cvtldt = ldt.toDateTime(DateTimeZone.forOffsetHours(-5));
        System.out.println("Converted date: " + cvtldt.toLocalDateTime().toDateTime().toDate().toString());
    }
}