package com.android.ct7liang.canvasdemo.newView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CanvasRefreshView extends View {

    private Paint paint;
    private Path path;
    private Rect rectF;

    public CanvasRefreshView(Context context) {
        super(context);
    }

    public CanvasRefreshView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //注意:关闭硬件加速器
        setLayerType(LAYER_TYPE_SOFTWARE, null);

        paint = new Paint();
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);

        path = new Path();

        rectF = new Rect(0, 0, 300, 300);
    }

    public CanvasRefreshView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(rectF, paint);

        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(), event.getY());
                invalidate(rectF);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(event.getX(), event.getY());
                invalidate(rectF);
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return true;
    }
}
