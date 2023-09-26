import org.joda.time.Period;
import org.joda.time.format.PeriodFormat;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder.LocaleIdToPrinterParser;

public class JodaTime34 {

    public static void main(String[] args) {
        LocaleIdToPrinterParser.setDefault(LocaleIdToPrinterParser.GERMAN);
        final PeriodFormatter periodFormatter = PeriodFormat.wordBased(LocaleIdToPrinterParser.ENGLISH);
        final Period period = new Period(6, 5, 4, 3);
        final String s = period.toString(periodFormatter);
        System.out.println("s = " + s);
    }

}