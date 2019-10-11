package com.android.ct7liang.canvasdemo.newView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class CanvasOvalView extends View {

    private Paint paint;

    public CanvasOvalView(Context context) {
        super(context);
    }

    public CanvasOvalView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setAntiAlias(true); //设置画笔是否抗锯齿
        paint.setColor(Color.GREEN); //设置画笔颜色

    }

    public CanvasOvalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



        @SuppressLint("DrawAllocation")
        RectF rectF = new RectF(100, 50, 600, 800);

        canvas.drawOval(rectF, paint);

        canvas.drawOval(100, 50, 600, 800, paint);
    }
}
