package jodatime;

import org.junit.Test;
import org.junit.Assert;

import org.joda.time.format.PeriodFormatterBuilder;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.Period;

public class JodaTime13 {
    // ID = 4585883
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

    @Test
    public void second() {
        Assert.assertEquals("00:00:01", OurDateTimeFormatter.format(1000));
    }

    @Test
    public void minute() {
        Assert.assertEquals("00:01:00", OurDateTimeFormatter.format(1000 * 60));
    }

    @Test
    public void hour() {
        Assert.assertEquals("01:00:00", OurDateTimeFormatter.format(1000 * 60 * 60));
    }

    @Test
    public void almostMidnight() {
        final int secondsInDay = 60 * 60 * 24;
        Assert.assertEquals("23:59:59", OurDateTimeFormatter.format(1000 * (secondsInDay - 1)));
    }

    @Test
    public void twoDaysAndAHalf() {
        final int secondsInDay = 60 * 60 * 24;
        Assert.assertEquals("12:00:00 and 2 days", OurDateTimeFormatter.format(1000 * secondsInDay * 5 / 2));
    }

    public static class OurDateTimeFormatter {
        public OurDateTimeFormatter() {
        }

        private final static PeriodFormatter dateFormat = new PeriodFormatterBuilder()
                .appendDays()
                .appendSuffix(" day", " days")
                .appendSeparator(" ")
                .appendHours()
                .appendSeparator(":")
                .appendMinutes().minimumPrintedDigits(2)
                .appendSeparator(":")
                .appendSeconds().minimumPrintedDigits(2)
                .toFormatter();

        public static String format(long millis) {
            return dateFormat.print(new Period(millis).normalizedStandard());
        }
    }
}