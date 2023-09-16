package androidExamples;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

public class Android16 extends SeekBar {

    private int oHeight = 320, oWidth = 29;
    private int oProgress = -1, oOffset = -1;
    private float xPos = -1, yPos = -1;
    private int top = -1, bottom = -1, left = -1, right = -1;

    public Android16(Context context) {
        super(context);
    }

    public Android16(Context context, AttributeSet attrs) {
        super(context, attrs);
        oOffset = this.getThumbOffset();
        oProgress = this.getProgress();
    }

    public Android16(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = View.MeasureSpec.getSize(heightMeasureSpec);
        oHeight = height;
        this.setMeasuredDimension(oWidth, oHeight);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(h, w, oldw, oldh);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        left = l;
        right = r;
        top = t;
        bottom = b;
    }

    @Override
    protected void onDraw(Canvas c) {
        c.rotate(90);
        c.translate(0, -29);
        super.onDraw(c);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        xPos = event.getX();
        yPos = event.getY();
        float progress = (yPos - this.getTop()) / (this.getBottom() - this.getTop());
        oOffset = this.getThumbOffset();
        oProgress = this.getProgress();
        Log.d("offset" + System.nanoTime(), Integer.toString(oOffset));
        Log.d("progress" + System.nanoTime(), Integer.toString(oProgress));

        float offset;

        offset = progress * (this.getBottom() - this.getTop());

        this.setThumbOffset((int) offset);

        Log.d("offset_postsetprogress" + System.nanoTime(), Integer.toString(oOffset));
        Log.d("progress_postsetprogress" + System.nanoTime(), Integer.toString(oProgress));

        this.setProgress((int) (100 * event.getY() / this.getBottom()));
        return true;
    }
}