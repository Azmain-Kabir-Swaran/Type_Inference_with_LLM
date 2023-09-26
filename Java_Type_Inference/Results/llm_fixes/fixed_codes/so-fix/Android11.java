package androidExamples;

import android.content.Context;
import android.graphics.Canvas;
import android.location.Location;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;

public class Android11 extends MyLocationOverlay {
    
    public Android11(Context arg0, MapView arg1) {
        super(arg0, arg1);
    }

    @Override
    public void drawMyLocation(Canvas canvas, MapView mapView, Location lastFix, GeoPoint myLocation, long when) {
        super.drawMyLocation(canvas, mapView, lastFix, myLocation, when);

        Location bLocation = new Location("reverseGeocoded");
        bLocation.setLatitude(FindList.gpslat);
        bLocation.setLongitude(FindList.gpslong);
        Location aLocation = new Location("reverseGeocoded");
        aLocation.setLatitude(myLocation.getLatitudeE6());
        aLocation.setLongitude(myLocation.getLongitudeE6());
        aLocation.set(aLocation);
        bLocation.set(bLocation);

        int distance = (int) aLocation.distanceTo(bLocation);
        String str = " (" + String.valueOf(distance) + " meters)";
    }

    static final class FindList {
        public static int gpslat = 1;
        public static int gpslong = 1;
    }
}