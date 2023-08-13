package jodatime;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatterBuilder;

public class JodaTime06 {

	public static void main(String[] args) {
		printDuration(new Duration(5000)); // Prints "5" => OK
		printDuration(new Duration(4900)); // Prints "4" => need "5"
		printDuration(new Duration(1000)); // Prints "1" => OK
		printDuration(new Duration(900));  // Prints "0" => need "1"
		printDuration(new Duration(0));    // Prints "0" => OK
	}
	
	static void printDuration(Duration d) {
		Period p = d.toPeriod();
		System.out.println(new PeriodFormatterBuilder().printZeroAlways().appendSeconds().toFormatter().print(p));
	}

}