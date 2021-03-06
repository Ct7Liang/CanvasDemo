package com.android.ct7liang.canvasdemo.newView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class CanvasQuadView extends View {

    private Paint paint;
    private Path path;
    private float px;
    private float py;

    public CanvasQuadView(Context context) {
        super(context);
    }

    public CanvasQuadView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(3);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);

        path = new Path();

    }

    public CanvasQuadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();

        int height = getHeight();

        path.reset();

        path.moveTo(width/4, height/2);

        if (px == 0 && py == 0){
            canvas.drawPoint(width/4, height/2, paint);
            canvas.drawPoint(width/4*3, height/2, paint);
        }

        if (px!=0 && py!=0){
            path.quadTo(px, py, width/4*3, height/2);
        }

        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                px = event.getX();
                py = event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }


}
