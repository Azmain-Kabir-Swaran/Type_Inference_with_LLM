package androidExamples;

import android.widget.LinearLayout;
import android.widget.ImageButton;
import android.content.Context;
import androidExamples.R;

//ID = 775188
public class Android21 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ImageButton b2 = new ImageButton(getApplicationContext());
        b2.setBackgroundResource(R.drawable.img);
        LinearLayout container = (LinearLayout) findViewById(R.id.lay);
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

class R {
    public static final class drawable {
        public static final int img = 0x7f020000;
    }
    public static final class id {
        public static final int lay = 0x7f060000;
    }
}