import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class JodaTime14 {

	public static void main(String[] args) {
		String start = "Sunday, January 09, 2011 6:15:00 PM";

		DateTimeFormatter parser1 = DateTimeFormat.forPattern("EEEE, MMMM dd, yyyy h:mm:ss aa");

		DateTime startTime = parser1.parseDateTime(start);
	}

}