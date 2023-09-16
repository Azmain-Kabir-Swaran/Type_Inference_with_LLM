import org.joda.time.DateTime;
import org.joda.time.Days;

public class JodaTime40 {
    public static void main(String[] args) {
        DateTime past = new DateTime(2010, 6, 20, 0, 0); // June 20th, 2010
        DateTime today = new DateTime(2010, 7, 24, 0, 0); // July 24th
        int days = Days.daysBetween(past, today).getDays(); // => 34
        System.out.println(days);
    }
}