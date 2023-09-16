package androidExamples;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.location.Location;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class Android11 implements GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
    private Context mContext;

    public Android11(Context context, GoogleMap map) {
        mContext = context;
        mMap = map;
        mMap.setOnMapClickListener(this);
    }

    @Override
    public void onMapClick(LatLng point) {
        // Handle map click events
    }

    private void drawMyLocation() {
        Location myLocation = mMap.getMyLocation();
        
        if (myLocation != null) {
            LatLng latLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
            BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.my_location_icon);
            mMap.addMarker(new MarkerOptions().position(latLng).icon(icon));
        }
    }

    private void drawDistance() {
        Location bLocation = new Location("reverseGeocoded");
        bLocation.setLatitude(FindList.gpslat);
        bLocation.setLongitude(FindList.gpslong);
        
        Location myLocation = mMap.getMyLocation();
        
        if (myLocation != null) {
            Location aLocation = new Location("reverseGeocoded");
            aLocation.setLatitude(myLocation.getLatitude());
            aLocation.setLongitude(myLocation.getLongitude());
        
            float distance = aLocation.distanceTo(bLocation);
            String str = "(" + String.valueOf(distance) + " meters)";
        }
    }

    static final class FindList {
        public static double gpslat = 1;
        public static double gpslong = 1;
    }
}