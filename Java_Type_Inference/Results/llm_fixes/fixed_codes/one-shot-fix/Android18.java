package androidExamples;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;

public class Android18 extends Activity implements OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.setTitle("MainActivity");
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, ChildActivity.class));
    }

}

class ChildActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        this.setTitle("ChildActivity");
    }
}