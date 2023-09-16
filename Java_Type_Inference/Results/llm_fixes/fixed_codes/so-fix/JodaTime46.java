import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class JodaTime46 {

	public static void main(String[] args) {
		DateTimeZone date = DateTimeZone.UTC;
		DateTime dateTime = new DateTime(date);
		dateTime = dateTime.plusDays(1);

	}

}