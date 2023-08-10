package jodatime;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodFormat;
import org.joda.time.PeriodType;
//ID = 8525863

public class JodaTime24 {

	public static String getFormattedDateDifference(DateTime startDate, DateTime endDate) {
	    Period p = new Period(startDate, endDate,
	            PeriodType.standard().withSecondsRemoved().withMillisRemoved());
	    return PeriodFormat.getDefault().print(p);
	}
}