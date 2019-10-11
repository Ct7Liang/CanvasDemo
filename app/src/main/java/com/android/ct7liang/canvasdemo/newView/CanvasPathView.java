package com.android.ct7liang.canvasdemo.newView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class CanvasPathView extends View {

    private Paint paint;
    private Path path;

    public CanvasPathView(Context context) {
        super(context);
    }

    public CanvasPathView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setAntiAlias(true); //设置画笔是否抗锯齿
        paint.setColor(Color.RED); //设置画笔颜色

        path = new Path();
    }

    public CanvasPathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



        canvas.drawPath(path, paint);
    }
}
