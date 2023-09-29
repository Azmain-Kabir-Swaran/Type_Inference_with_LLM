import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.util.Date;

public class JodaTime22 {

    public static void main(String[] args) {

    }

    public String getDateFromDateTime(Date date, Boolean display) throws ParseException {

        DateTimeFormatter dtFormatter;

        if (display)
            dtFormatter = DateTimeFormat.forPattern("MM/dd/yyyy");
        else
            dtFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");

        DateTime dt = new DateTime(date);
        String myDate = dt.toString(dtFormatter);

        System.out.println("OrderDisplayUtil.java:getDateFromDateTime(" + date + ", " + display + "): " + "myDate = " + myDate);

        return myDate;
    }
}