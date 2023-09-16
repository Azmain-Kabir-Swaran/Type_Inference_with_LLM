import org.joda.time.DateTime;
import java.util.ArrayList;

public class JodaTime27 {

	public static void main(String[] args) {
		ArrayList<DateTime> monthStarts = new ArrayList<>();
		int firstYear = 0;
		int lastYear = 0;
		for (int y = firstYear; y <= lastYear; y++) {
		    for (int m = 1; m <= 12; m++) {
		      monthStarts.add(new DateTime(y + "-" + m + "-01"));
		    }
		}
	}

}