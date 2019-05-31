package com.android.ct7liang.canvasdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class View03 extends View {

    private Paint mPaint = new Paint();
    private Paint tPaint = new Paint();
    private Rect r;
    private RectF rf;
    private RectF rf1;

    public View03(Context context) {
        super(context);
    }

    public View03(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(5);

        tPaint.setAntiAlias(true);
        tPaint.setColor(Color.BLACK);
        tPaint.setTextSize(30);

        r = new Rect(50, 400, 350, 700);
        rf = new RectF(50, 750, 350, 1050);
        rf1 = new RectF(50, 1100, 350, 1400);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(50, 50, 350, 350, mPaint);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(50, 50, 350, 350, mPaint);

        setText1(canvas);
        
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(r, mPaint);

        setText2(canvas);

        mPaint.setColor(Color.BLACK);
        canvas.drawRect(rf, mPaint);

        setText3(canvas);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rf1, mPaint);
        rf1.inset(50, 50);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawRect(rf1, mPaint);

        setText4(canvas);

    }

    private void setText1(Canvas canvas){
        canvas.drawText("mPaint.setColor(Color.GREEN)", 400, 105, tPaint);
        canvas.drawText("mPaint.setStyle(Paint.Style.FILL)", 400, 145, tPaint);
        canvas.drawText("canvas.drawRect(50, 50, 350, 350, mPaint)", 400, 185, tPaint);
        canvas.drawText("mPaint.setColor(Color.BLACK)", 400, 225, tPaint);
        canvas.drawText("mPaint.setStyle(Paint.Style.STROKE)", 400, 265, tPaint);
        canvas.drawText("canvas.drawRect(50, 50, 350, 350, mPaint)", 400, 305, tPaint);
    }

    private void setText2(Canvas canvas){
        canvas.drawText("Rect r = new Rect(50, 400, 350, 700)", 400, 455, tPaint);
        canvas.drawText("mPaint.setStyle(Paint.Style.FILL_AND_STROKE)", 400, 495, tPaint);
        canvas.drawText("mPaint.setColor(Color.GRAY)", 400, 535, tPaint);
        canvas.drawText("canvas.drawRect(r, mPaint)", 400, 575, tPaint);
    }

    private void setText3(Canvas canvas){
        canvas.drawText("RectF rf = new RectF(50, 750, 350, 1050)", 400, 805, tPaint);
        canvas.drawText("mPaint.setStyle(Paint.Style.FILL_AND_STROKE)", 400, 845, tPaint);
        canvas.drawText("mPaint.setColor(Color.BLACK)", 400, 885, tPaint);
        canvas.drawText("canvas.drawRect(r, mPaint)", 400, 925, tPaint);
    }

    private void setText4(Canvas canvas){
        canvas.drawText("RectF rf1 = new RectF(50, 1100, 350, 1400)", 400, 1150, tPaint);
        canvas.drawText("mPaint.setStyle(Paint.Style.STROKE)", 400, 1190, tPaint);
        canvas.drawText("canvas.drawRect(rf1, mPaint)", 400, 1230, tPaint);
        canvas.drawText("rf1.inset(50, 50)", 400, 1270, tPaint);
        canvas.drawText("mPaint.setStyle(Paint.Style.FILL_AND_STROKE)", 400, 1310, tPaint);
        canvas.drawText("canvas.drawRect(rf1, mPaint)", 400, 1350, tPaint);
    }
}
