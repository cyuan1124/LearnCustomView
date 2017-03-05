package rocks.luna.learncustomview.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by cyuan on 3/4/17.
 */

public class DrawPointLineRectView extends View {

    public static final int DRAW_POINT = 1;
    public static final int DRAW_LINE = 2;
    public static final int DRAW_RECT = 3;

    private int mDrawMode = DRAW_POINT;
    private Paint mPaint;

    private Rect mRect;
    private RectF mRectF;

    public DrawPointLineRectView(Context context) {
        super(context, null);
    }

    public DrawPointLineRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public DrawPointLineRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);       // Set paint color
        mPaint.setStyle(Paint.Style.FILL);  // Set paint mode to FILL
        mPaint.setStrokeWidth(10f);

        mRect = new Rect(100, 500, 800, 900);
        mRectF = new RectF(100, 1000, 800, 1300);
    }

    public void setDrawMode(int mode) {
        this.mDrawMode = mode;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mDrawMode == DRAW_LINE) {
            drawLines(canvas);
        } else if (mDrawMode == DRAW_POINT) {
            drawPoints(canvas);
        } else {
            drawRects(canvas);
        }
    }

    private void drawPoints(Canvas canvas) {
        // Points
        canvas.drawPoint(200, 200, mPaint);     // Draw a point at (200, 200)
        canvas.drawPoints(new float[]{          // Draw a set of points from float array
                500, 500,
                500, 600,
                500, 700
        }, mPaint);
    }

    private void drawLines(Canvas canvas) {
        // Lines
        canvas.drawLine(300, 300, 500, 600, mPaint);    // 在坐标(300,300)(500,600)之间绘制一条直线
        canvas.drawLines(new float[]{               // 绘制一组线 每四数字(两个点的坐标)确定一条线
                100, 200, 200, 200,
                100, 300, 200, 300
        }, mPaint);
    }

    private void drawRects(Canvas canvas) {
        // Rects
        canvas.drawRect(100, 100, 800, 400, mPaint);

        // 第二种
        canvas.drawRect(mRect, mPaint);

        // 第三种
        canvas.drawRect(mRectF, mPaint);
    }
}
