package androidExamples;

import android.app.Service;
import android.os.PowerManager;
import android.os.IBinder;
import android.content.Context;
import android.content.Intent;
//ID = 992508

public class Android29 extends Service {

    PowerManager.WakeLock wl;

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
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
        if (wl != null) {
            wl.release();
        }
    }
}