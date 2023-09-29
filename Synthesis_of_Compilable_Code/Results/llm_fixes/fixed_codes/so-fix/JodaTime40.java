package jodatime;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class JodaTime40 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        @SuppressWarnings("deprecation")
        java.util.Date past = new java.util.Date(110, 5, 20); // June 20th, 2010
        java.util.Date today = new java.util.Date(110, 6, 24); // July 24th 
        int days = Days.daysBetween(new DateTime(past.getTime()), new DateTime(today.getTime())).getDays(); // => 34
    }

}