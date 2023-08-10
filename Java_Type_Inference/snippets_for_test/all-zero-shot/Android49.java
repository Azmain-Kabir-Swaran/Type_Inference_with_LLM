package androidExamples;
import android.widget.LinearLayout;
import com.example.R;
import android.view.Gravity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
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