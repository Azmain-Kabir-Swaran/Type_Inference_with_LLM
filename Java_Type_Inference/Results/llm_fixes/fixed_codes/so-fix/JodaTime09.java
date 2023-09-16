import java.util.TimeZone;
import org.joda.time.DateTimeZone;

public class JodaTime09 {

	public static void main(String[] args) {
		final String string_from_3rd_party = "GMT+08:00";
		System.out.println(TimeZone.getTimeZone(string_from_3rd_party));
		System.out.println(DateTimeZone.forID(string_from_3rd_party));
	}

}