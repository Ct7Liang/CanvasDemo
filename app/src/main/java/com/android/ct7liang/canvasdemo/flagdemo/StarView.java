package com.android.ct7liang.canvasdemo.flagdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class StarView extends View {

    private Paint rPaint;
    private Paint yPaint;
    private RectF rectF;

    public StarView(Context context) {
        super(context);
    }

    public StarView(Context context, AttributeSet attrs) {
        super(context, attrs);

        rPaint = new Paint();
        rPaint.setStyle(Paint.Style.FILL);
        rPaint.setColor(Color.RED);
        rPaint.setAntiAlias(true);

        yPaint = new Paint();
        yPaint.setStyle(Paint.Style.FILL);
        yPaint.setColor(Color.TRANSPARENT);
        yPaint.setAntiAlias(true);
    }

    public StarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = width;

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        rectF = new RectF(0, 0, canvas.getWidth(), canvas.getHeight());

        canvas.drawArc(rectF, -90f, 144f, true, yPaint);
        canvas.drawArc(rectF, -90f, 144f, false, rPaint);



//        for (int i = 0; i < 2; i++) {
//            float startAngle = -90 + i*72;
//            canvas.drawArc(rectF, startAngle, 144f, true, yPaint);
//            canvas.drawArc(rectF, startAngle, 144f, false, rPaint);
//        }



    }
}
