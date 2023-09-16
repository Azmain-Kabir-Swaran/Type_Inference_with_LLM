import org.joda.time.DateTimeZone;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

public class JodaTime45 {

    public static class FastDateTimeZoneProvider implements org.joda.time.tz.Provider {
        public final Set<String> AVAILABLE_IDS = new HashSet<>();

        public DateTimeZone getZone(String id) {
            if (id == null) {
                return DateTimeZone.UTC;
            }

            TimeZone tz = TimeZone.getTimeZone(id);
            if (tz == null) {
                return DateTimeZone.UTC;
            }

            int rawOffset = tz.getRawOffset();

            if (tz.inDaylightTime(new Date())) {
                rawOffset += tz.getDSTSavings();
            }

            return DateTimeZone.forOffsetMillis(rawOffset);
        }

        public Set<String> getAvailableIDs() {
            return AVAILABLE_IDS;
        }
    }
}