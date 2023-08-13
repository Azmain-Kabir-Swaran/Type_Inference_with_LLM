import android.content.ComponentName;
import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.content.IntentFilter;
import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.util.Log;

//ID = 1215817

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
        } catch (IntentFilter.MalformedMimeTypeException e) {
            Log.e(TAG, e.toString());
        }

        BroadcastReceiver receiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) { 
                Log.d(TAG, "Received intent "+intent);
                intent.setComponent(new ComponentName(context, Uploader.class));
                startActivity(intent);
            }
        };
        
        registerReceiver(receiver, intentFilter);

    }

    class Uploader {
    }
}