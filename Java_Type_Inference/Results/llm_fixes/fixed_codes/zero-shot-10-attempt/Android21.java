import android.widget.LinearLayout;
import android.widget.ImageButton;
import android.content.Context;

public class Android21 {

	public static void main(String[] args) {
		ImageButton b2 = new ImageButton(getApplicationContext());
		b2.setBackgroundResource(R.drawable.img);
		LinearLayout container = (LinearLayout) findViewById(R.id.lay);
		container.addView(b2);
	}

	private static LinearLayout findViewById(int lay) {
		return null;
	}

	private static Context getApplicationContext() {
		return null;
	}

}