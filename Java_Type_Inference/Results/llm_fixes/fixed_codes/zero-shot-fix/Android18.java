package androidExamples;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;

public class Android18 extends Activity implements DialogInterface.OnClickListener, View.OnClickListener {
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.setTitle("MainActivity");

        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(DialogInterface arg0, int arg1) {
        startActivity(new Intent(this, ChildActivity.class));
    }
    
    @Override
    public void onClick(View view) {
        if (view == button) {
            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show();
        }
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