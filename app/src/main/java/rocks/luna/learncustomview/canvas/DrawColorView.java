package rocks.luna.learncustomview.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by cyuan on 3/4/17.
 */

public class DrawColorView extends View {

    private Paint mPaint = new Paint();
    private int mColor = Color.WHITE;

    public DrawColorView(Context context) {
        super(context);
        initPaint();
    }

    public DrawColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public DrawColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
    }

    private void initPaint() {
        mPaint.setColor(Color.BLACK);       // Set paint color
        mPaint.setStyle(Paint.Style.FILL);  // Set paint mode to FILL
        mPaint.setStrokeWidth(10f);         // Set stroke width to 10px
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(mColor);
    }

    public void drawColor(int color) {
        this.mColor = color;
        invalidate();
    }
}
