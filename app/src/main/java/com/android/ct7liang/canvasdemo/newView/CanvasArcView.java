package com.android.ct7liang.canvasdemo.newView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class CanvasArcView extends View {

    private Paint paint;

    public CanvasArcView(Context context) {
        super(context);
    }

    public CanvasArcView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setAntiAlias(true); //设置画笔是否抗锯齿
        paint.setColor(Color.RED); //设置画笔颜色


    }

    public CanvasArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.drawArc(0, 0, 400, 400, 0f, 90f, true, paint);

//        paint.setColor(Color.BLUE);
        @SuppressLint("DrawAllocation")
        RectF rectF = new RectF(200, 200, 700, 800);
//        canvas.drawRect(rectF, paint);

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF, 0f, 90f, true, paint);
    }
}
