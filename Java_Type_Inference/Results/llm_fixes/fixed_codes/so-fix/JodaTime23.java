import org.joda.time.LocalDate;
import org.joda.time.DateTimeConstants;

public class JodaTime23 {

    LocalDate getNearestDayOfWeek(LocalDate ld, String day) {
        LocalDate target = ld.dayOfWeek().setCopy(getDayOfWeek(day));
        if (ld.getDayOfWeek() > DateTimeConstants.SATURDAY) {
            target = target.plusWeeks(1);
        }
        return target;
    }

    private int getDayOfWeek(String day) {
        switch (day) {
            case "Monday":
                return DateTimeConstants.MONDAY;
            case "Tuesday":
                return DateTimeConstants.TUESDAY;
            case "Wednesday":
                return DateTimeConstants.WEDNESDAY;
            case "Thursday":
                return DateTimeConstants.THURSDAY;
            case "Friday":
                return DateTimeConstants.FRIDAY;
            case "Saturday":
                return DateTimeConstants.SATURDAY;
            case "Sunday":
                return DateTimeConstants.SUNDAY;
            default:
                return -1;
        }
    }
}