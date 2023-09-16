package androidExamples;

import android.content.Context;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class Android21 {

	public static void main(String[] args) {

		ImageButton b2 = new ImageButton(getApplicationContext());
		b2.setBackgroundResource(R.drawable.img);
		LinearLayout container = findViewById(R.id.lay);
		container.addView(b2);
	}

	private static LinearLayout findViewById(int lay) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Context getApplicationContext() {
		// TODO Auto-generated method stub
		return null;
	}
}