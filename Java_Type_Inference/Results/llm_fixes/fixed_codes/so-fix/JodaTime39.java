import org.joda.time.DateTime;

public class JodaTime39 {

	public static void main(String[] args) {
	    DateTime d1 = new DateTime();
	    DateTime d2 = new DateTime();

	    long diffInMillis = d2.getMillis() - d1.getMillis();
	}

}