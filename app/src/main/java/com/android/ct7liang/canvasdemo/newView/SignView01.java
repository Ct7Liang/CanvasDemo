package com.android.ct7liang.canvasdemo.newView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SignView01 extends View{

    private Paint paint0;
    private Paint paint;
    private Path path;

    private Bitmap bitmap;
    private Canvas bitmapCanvas;

    public SignView01(Context context) {
        super(context);
    }

    public SignView01(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint0 = new Paint();
        paint0.setStyle(Paint.Style.STROKE);

        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(6);

        path = new Path();
    }

    public SignView01(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (bitmap == null){
            bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            bitmapCanvas = new Canvas(bitmap);
        }

        canvas.drawBitmap(bitmap, 0, 0, paint0);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path = new Path();
                path.moveTo(event.getX(), event.getY());

                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(event.getX(), event.getY());

                bitmapCanvas.drawPath(path, paint);

                invalidate();

                break;
            case MotionEvent.ACTION_UP:


                break;
        }
        return true;
    }

    public void setPColor(int type){
        switch (type){
            case 0:
                paint.setColor(Color.BLACK);
                break;
            case 1:
                paint.setColor(Color.RED);
                break;
            case 2:
                paint.setColor(Color.GREEN);
                break;
        }
    }

    public void clear(){
        bitmap = null;
        invalidate();
    }
}
