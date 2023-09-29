import android.content.Context;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class Android21 {

    public static void main(String[] args) {
        ImageButton b2 = new ImageButton(getApplicationContext());
        b2.setBackgroundResource(androidExamples.R.drawable.img);
        android.widget.LinearLayout container = (android.widget.LinearLayout) findViewById(androidExamples.R.id.lay);
        container.addView(b2);
    }

    private static LinearLayout findViewById(int lay) {
        return null;
    }

    private static Context getApplicationContext() {
        return null;
    }

    private static class androidExamples {
        private static class R {
            private static class drawable {
                private static int img;
            }
            private static class id {
                private static int lay;
            }
        }
    }
}