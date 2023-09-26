package androidExamples;

import android.content.Intent;
import android.os.PowerManager;
import android.content.Context;
import android.os.IBinder;
import android.app.Service;
import android.os.PowerManager.WakeLock;

public class Android29 extends Service {

    private WakeLock wl;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "My Tag");
        wl.acquire();
    }

    @Override
    public void onDestroy() {
        wl.release();
    }

}