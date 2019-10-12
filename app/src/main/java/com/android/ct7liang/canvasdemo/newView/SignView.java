package com.android.ct7liang.canvasdemo.newView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class SignView extends View {

    private Paint paint;
    private Path path;

    public SignView(Context context) {
        super(context);
    }

    public SignView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(7);
        paint.setStyle(Paint.Style.STROKE);

        path = new Path();
    }

    public SignView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("ct7liang123", "down");
//                path.moveTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                int historySize = event.getHistorySize();
                Log.i("ct7liang123", "move: " + historySize);
                for (int i = 0; i < historySize; i++) {
                    float historicalX = event.getHistoricalX(i);
                    float historicalY = event.getHistoricalY(i);
                    path.lineTo(historicalX, historicalY);
                }
//                path.lineTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_UP:
//                int historySize = event.getHistorySize();
                Log.i("ct7liang123", "up: ");
//                for (int i = 0; i < historySize; i++) {
//                    float historicalX = event.getHistoricalX(i);
//                    float historicalY = event.getHistoricalY(i);
//                    path.lineTo(historicalX, historicalY);
//                }
                break;
        }
        invalidate();
        return true;
    }

    private void clear(Canvas canvas){

    }
}
