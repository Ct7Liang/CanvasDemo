package com.android.ct7liang.canvasdemo.newView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class CanvasQuadView extends View {

    private Paint paint;
    private Path path1;
    private Path path2;

    public CanvasQuadView(Context context) {
        super(context);
    }

    public CanvasQuadView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true); //设置画笔是否抗锯齿
        paint.setColor(Color.BLUE); //设置画笔颜色
        paint.setStrokeWidth(10f);

        path1 = new Path();
        path1.moveTo(600, 100);
        path1.lineTo(200, 200);
        path1.lineTo(400, 400);

        path1.moveTo(600, 600);
        path1.lineTo(800, 800);


        path2 = new Path();
        path2.lineTo(200, 200);
        path2.setLastPoint(300, 400);
        path2.lineTo(600, 600);

    }

    public CanvasQuadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path1, paint);

        paint.setColor(Color.GREEN); //设置画笔颜色
        paint.setStrokeWidth(5f);

        canvas.drawPath(path2, paint);
    }
}