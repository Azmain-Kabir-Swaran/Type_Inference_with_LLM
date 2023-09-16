package jodatime;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class JodaTime38 {

    public static void main(String[] args) {
        String dateTime = "11/15/2013 08:00:00";
        DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
        DateTime jodatime = dtf.parseDateTime(dateTime);
        DateTimeFormatter dtfOut = DateTimeFormat.forPattern("MM/dd/yyyy");
        System.out.println(dtfOut.print(jodatime));
    }

}