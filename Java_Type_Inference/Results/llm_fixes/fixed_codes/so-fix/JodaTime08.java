import org.joda.time.*;

public class JodaTime08 {
    public boolean testIfJodaTimePeriodsHandlesPeriodTypesOtherThanMinutesAndHours() {
        long twentyDaysInMillis = org.joda.time.Duration.standardDays(20).getMillis();
        Period twoWeeks = new Period(twentyDaysInMillis, PeriodType.weeks());
        return (2 == twoWeeks.getWeeks()) ? true : false; 
    }
}