package androidExamples;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
//ID = 522800

public class Android09 {
	float seconds;
	public Timer gametimer;
	void updatecount() { TextView t = (TextView)findViewById(R.id.topscore);
	t.setText("Score: 10 - Time: "+seconds+" seconds");
	t.postInvalidate();
	}
	private TextView findViewById(int topscore) {
		// TODO Auto-generated method stub
		return null;
	}
	public void onCreate(Bundle sis) {

		gametimer.schedule(new TimerTask() { public void run() {
			seconds+=0.1; updatecount();
		} }, 100, 100);
	}
}