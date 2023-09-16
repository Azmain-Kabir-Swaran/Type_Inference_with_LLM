package androidExamples;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Chronometer;

public class Android10 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Context context = null; // Replace null with the appropriate Context object
        Chronometer t = new Chronometer(context); // Pass the Context object to the constructor
        long time = SystemClock.elapsedRealtime() - t.getBase();
        Log.d(null, "Was: " + time);
        t.setBase(SystemClock.elapsedRealtime());
        t.start();
    }
}