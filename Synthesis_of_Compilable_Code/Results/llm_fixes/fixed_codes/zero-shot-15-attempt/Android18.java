package androidExamples;

import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;

public class Android18 extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.setTitle("MainActivity");
    }

    @Override
    public void onClick(View arg0) {
        startActivity(new Intent(this, ChildActivity.class));
    }
}

class ChildActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        this.setTitle("ChildActivity");
    }
}