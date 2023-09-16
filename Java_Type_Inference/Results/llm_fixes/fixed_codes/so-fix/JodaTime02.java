import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class JodaTime02 {

    public static void main(String[] args) {
        DateMidnight today = new DateMidnight(2009, 2, 24);
        DateTimeZone zone = today.getZone();

        DateTime previousTransition =
            new DateTime(zone.previousTransition(today.getMillis()));
        
        System.out.println(previousTransition);

        DateTime nextTransition =
            new DateTime(zone.nextTransition(today.getMillis()));
        
        System.out.println(nextTransition);
    
    }

}