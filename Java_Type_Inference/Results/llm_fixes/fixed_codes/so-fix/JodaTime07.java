import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.Days;
import java.util.Calendar;

public class JodaTime07 {

    public static void main(String[] args) {
        
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        Date someDate = new Date();
        Date today = Calendar.getInstance().getTime();

        try {
            someDate = formatter.parse("06/22/2010");
        } catch (ParseException pe) {
            System.out.println("Parser Exception");
        }

        int days = Days.daysBetween(new DateTime(someDate.getTime()), new DateTime(today.getTime())).getDays();

        System.out.println(" Days Between " + someDate + " : " + today + " - " + days);

    }

}