package androidExamples;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.app.Activity;
import android.content.Context;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;

import java.util.List;

public class Android39 extends MapActivity {

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        LinearLayout linearLayout = new LinearLayout(this);
        setContentView(linearLayout);

        MapView myMapView = new MapView(this, getString(R.string.google_maps_api_key));
        myMapView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        linearLayout.addView(myMapView);

        MapController mapController = myMapView.getController();

        List<Overlay> overlays = myMapView.getOverlays();
        MyLocationOverlay myLocationOverlay = new MyLocationOverlay(this, myMapView);
        overlays.add(myLocationOverlay);
        myLocationOverlay.enableMyLocation();
    }

    protected boolean isRouteDisplayed() {
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();

        MapView myMapView = (MapView) findViewById(R.id.map);
        myMapView.invalidate();
    }
}