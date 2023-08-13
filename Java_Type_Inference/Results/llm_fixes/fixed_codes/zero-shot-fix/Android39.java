package androidExamples;

import android.os.Bundle;
import android.widget.LinearLayout;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;

import java.util.List;

public class Android39 extends MapActivity {

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        // Replace "activity_main" with the correct layout file name in the setContentView method
        setContentView(R.layout.activity_main);

        MapView myMapView = (MapView) findViewById(R.id.map_view);
        MapController mapController = myMapView.getController();

        List<Overlay> overlays = myMapView.getOverlays();
        MyLocationOverlay myLocationOverlay = new MyLocationOverlay(this, myMapView);
        overlays.add(myLocationOverlay);
        myLocationOverlay.enableMyLocation();
    }

    protected boolean isRouteDisplayed() {
        return false;
    }

}