import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JodaTime28 {
    public static void main(String[] args) {
        DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("MM/dd/yyyy");

        DateTime startDate = dateFormatter.parseDateTime("01/02/2012");
        DateTime endDate = dateFormatter.parseDateTime("01/31/2012");

        List<LocalDate> dates = new ArrayList<LocalDate>();

        int days = Days.daysBetween(startDate, endDate).getDays();
    }
}