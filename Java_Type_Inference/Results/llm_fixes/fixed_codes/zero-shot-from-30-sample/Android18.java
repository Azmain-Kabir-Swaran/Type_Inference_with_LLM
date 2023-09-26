package androidExamples;

import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;

public class Android18 extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.setTitle("MainActivity");
    }

    @Override
    public void onClick(View view) {
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