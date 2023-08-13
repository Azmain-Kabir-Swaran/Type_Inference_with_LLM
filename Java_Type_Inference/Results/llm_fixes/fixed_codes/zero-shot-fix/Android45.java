package androidExamples;
import android.content.ComponentName;
import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.content.Context;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.webkit.MimeTypeMap;
//ID = 1215817

public class Android45 extends Activity {

private static final String TAG = "MyActivity";

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction(Intent.ACTION_SEND);
    intentFilter.addCategory(Intent.CATEGORY_DEFAULT);
    intentFilter.addCategory(Intent.CATEGORY_BROWSABLE);
    intentFilter.addDataScheme("file");
    intentFilter.addDataScheme("content");

    Intent x = registerReceiver(new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) { 
            Log.d(TAG, "Received intent "+intent);
            intent.setComponent(new ComponentName(context, Uploader.class));
            startActivity(intent);
        }
    }, intentFilter);

    if (x==null)
        Log.i(TAG, "failed to regist a receiver");
    else
        Log.i(TAG, "registed a receiver successfully");
}

class Uploader {

}
}