import android.content.ComponentName;
import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.content.Context;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.webkit.MimeTypeParseException;

public class Android45 extends Activity {

    private static final String TAG = "MyActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SEND);
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT);
        try {
            intentFilter.addDataType("image/*");
        } catch (MimeTypeParseException e) {
            Log.e(TAG, e.toString());
        }

        Intent x = registerReceiver(new MyBroadcastReceiver(), intentFilter);
    }

    private class MyBroadcastReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) { 
            Log.d(TAG, "Received intent " + intent);
            intent.setComponent(new ComponentName(context, Uploader.class));
            startActivity(intent);
        }
    }
}