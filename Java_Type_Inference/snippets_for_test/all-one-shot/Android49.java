package androidExamples;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
//ID = 1325576

public class Android49 extends LinearLayout {
    public Android49(Context context, AttributeSet attrs) {
        super(context, attrs);
        ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.main, this, true);
        setGravity(Gravity.CENTER);
    }

    public Android49(Context context) {
        this(context,null);
    }
}