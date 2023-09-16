package androidExamples;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

public class Android41 extends View {
    TextView tv;

    public Android41(Context context) {
        super(context);
        setBackgroundColor(Color.RED);
    }

    public void adText(TextView tv) {
        this.tv = tv;
        tv.setVisibility(View.VISIBLE);
    }
}