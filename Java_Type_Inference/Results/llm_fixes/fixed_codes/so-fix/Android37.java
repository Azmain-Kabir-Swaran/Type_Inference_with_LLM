import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class Android37 extends Activity implements Runnable {
    public ProgressDialog mProgress;

    // UI has a button that when pressed calls send

    public void send() {
        mProgress = ProgressDialog.show(this, "Please wait",
                "Please wait",
                true, true);
        Thread thread = new Thread(this);
        thread.start();
    }

    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Message msg = mHandler.obtainMessage();
        mHandler.sendMessage(msg);
    }

    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mProgress.dismiss();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}