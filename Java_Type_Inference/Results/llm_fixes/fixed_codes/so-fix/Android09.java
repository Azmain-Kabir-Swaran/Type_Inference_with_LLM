import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Android09 extends Activity {
    float seconds;
    public Timer gametimer;
    
    void updatecount() { 
        TextView t = (TextView)findViewById(R.id.topscore);
        t.setText("Score: 10 - Time: "+seconds+" seconds");
        t.postInvalidate();
    }
    
    public void onCreate(Bundle sis) {
        super.onCreate(sis);
        setContentView(R.layout.main);
        
        gametimer = new Timer();
        gametimer.schedule(new TimerTask() { 
            public void run() {
                seconds+=0.1; 
                updatecount();
            } 
        }, 100, 100);
    }
}