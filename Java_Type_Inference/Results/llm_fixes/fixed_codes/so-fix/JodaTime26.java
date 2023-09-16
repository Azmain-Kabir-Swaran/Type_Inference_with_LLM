import org.joda.time.Duration;
import org.joda.time.Period;

public class JodaTime26 {

	public static void main(String[] args) {
		Duration duration = new Duration(1328223198241L - 1326308781131L); // fixing the error by importing the Duration class
		Period p2 = new Period(duration.getMillis()); // fixing the error by importing the Period class
		System.out.println(p2.getDays());
		System.out.println(p2.getHours());
	}
}