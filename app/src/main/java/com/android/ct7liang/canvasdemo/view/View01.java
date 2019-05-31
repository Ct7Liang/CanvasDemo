package com.android.ct7liang.canvasdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class View01 extends View {

    private Paint mPaint;

    private float[] floats = {50, 400, 150, 600, 500, 600, 700, 400};
    private float[] floats1 = {100, 850, 300, 850, 500, 850, 700, 850};
    private float[] floats2 = {100, 1000, 300, 1000, 500, 1000, 700, 1000};

    public View01(Context context) {
        super(context);
    }

    public View01(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(5);
        mPaint.setTextSize(30);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(50, 50, 1000, 200, mPaint);
        setTexts1(canvas);

        canvas.drawLines(floats, mPaint);
        setTexts2(canvas);

        canvas.drawLines(floats1, mPaint);
        setTexts3(canvas);

        canvas.drawLines(floats2, 2, 4, mPaint);
        setTexts4(canvas);

    }

    private void setTexts1(Canvas canvas){
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(Color.BLACK);
        p.setStrokeWidth(8);
        p.setTextSize(35);
        canvas.drawText("canvas.drawLine(50, 50, 1000, 200, mPaint)", 30, 300, p);
    }

    private void setTexts2(Canvas canvas){
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(Color.BLACK);
        p.setStrokeWidth(8);
        p.setTextSize(35);
        canvas.drawText("float[] floats = {50, 400, 150, 600, 500, 600, 700, 400}", 30, 700, p);
        canvas.drawText("canvas.drawLines(floats, mPaint)", 30, 750, p);
    }

    private void setTexts3(Canvas canvas){
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(Color.BLACK);
        p.setStrokeWidth(8);
        p.setTextSize(35);
        canvas.drawText("float[] floats1 = {100, 850, 300, 850, 500, 850, 700, 850}", 30, 900, p);
        canvas.drawText("canvas.drawLines(floats1, mPaint)", 30, 950, p);
    }

    private void setTexts4(Canvas canvas){
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(Color.BLACK);
        p.setStrokeWidth(8);
        p.setTextSize(35);
        canvas.drawText("float[] floats2 = {100, 1000, 300, 1000, 500, 1000, 700, 1000}", 30, 1050, p);
        canvas.drawText("canvas.drawLines(floats2, 2, 4, mPaint)", 30, 1100, p);
    }
}