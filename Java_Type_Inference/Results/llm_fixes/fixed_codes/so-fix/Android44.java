package androidExamples;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Android44 extends Service {
    public volatile Thread runner;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        startThread();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        android.util.Log.v("@@@@@@@@@@@@@@@@@@@@", "DoScan.onDestroy");
        stopThread();
    }

    public synchronized void startThread() {
        if (runner == null) {
            runner = new Thread(new Runnable() {
                @Override
                public void run() {
                    // Add code to be executed in the thread
                }
            });
            android.util.Log.v("@@@@@@@@@@@@@@@@@@@@", "DoScan.startthread");
            runner.start();
        }
    }

    public synchronized void stopThread() {
        if (runner != null) {
            android.util.Log.v("@@@@@@@@@@@@@@@@@@@@", "DoScan.stopthread");
            Thread moribund = runner;
            runner = null;
            moribund.interrupt();
            android.util.Log.v("@@@@@@@@@@@@@@@@@@@@", "interrupted?" + moribund.isInterrupted());
        }
    }
}