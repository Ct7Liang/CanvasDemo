package com.android.ct7liang.canvasdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class View02 extends View {

    private Paint mPaint = new Paint();

    public View02(Context context) {
        super(context);
    }

    public View02(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(150, 150, 100, mPaint);
        setText1(canvas);

        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(150, 400, 100, mPaint);
        setText2(canvas);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(150, 650, 100, mPaint);
        setText3(canvas);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(150, 900, 100, mPaint);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.GREEN);
        canvas.drawCircle(150, 900, 100, mPaint);
        setText4(canvas);
    }

    private void setText1(Canvas canvas){
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        p.setTextSize(30);
        p.setAntiAlias(true);
        canvas.drawText("mPaint.setStyle(Paint.Style.FILL_AND_STROKE)", 300, 125, p);
        canvas.drawText("canvas.drawCircle(150, 150, 100, mPaint)", 300, 175, p);
    }

    private void setText2(Canvas canvas){
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        p.setTextSize(30);
        p.setAntiAlias(true);
        canvas.drawText("mPaint.setStyle(Paint.Style.FILL)", 300, 375, p);
        canvas.drawText("canvas.drawCircle(400, 150, 100, mPaint)", 300, 425, p);
    }

    private void setText3(Canvas canvas){
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        p.setTextSize(30);
        p.setAntiAlias(true);
        canvas.drawText("mPaint.setStyle(Paint.Style.STROKE)", 300, 625, p);
        canvas.drawText("canvas.drawCircle(150, 650, 100, mPaint)", 300, 675, p);
    }

    private void setText4(Canvas canvas){
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        p.setTextSize(30);
        p.setAntiAlias(true);
        canvas.drawText("mPaint.setStyle(Paint.Style.STROKE)", 300, 845, p);
        canvas.drawText("mPaint.setColor(Color.BLACK)", 300, 875, p);
        canvas.drawText("canvas.drawCircle(150, 900, 100, mPaint)", 300, 905, p);
        canvas.drawText("mPaint.setStyle(Paint.Style.FILL)", 300, 935, p);
        canvas.drawText("mPaint.setColor(Color.GREEN)", 300, 965, p);
        canvas.drawText("canvas.drawCircle(150, 900, 100, mPaint)", 300, 995, p);
    }
}
