package com.android.ct7liang.canvasdemo.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class PaintView extends View {

    private Paint paint;

    public PaintView(Context context) {
        super(context);
    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();

        //设置颜色
        paint.setColor(Color.BLACK);

        //设置宽度
        paint.setStrokeWidth(50);

        //设置样式
        paint.setStyle(Paint.Style.STROKE); //描边
//        paint.setStyle(Paint.Style.FILL); //填充
//        paint.setStyle(Paint.Style.FILL_AND_STROKE); //填充加描边

        //设置是否抗锯齿
        paint.setAntiAlias(true);

        //设置是否仿抖动
        paint.setDither(true);

        //设置线冒样式
        paint.setStrokeCap(Paint.Cap.ROUND); //圆形线冒
        paint.setStrokeCap(Paint.Cap.SQUARE); //方形线冒
        paint.setStrokeCap(Paint.Cap.BUTT); //无线冒

        //设置线的拐角
        paint.setStrokeJoin(Paint.Join.BEVEL); //两条线的拐角是平的
        paint.setStrokeJoin(Paint.Join.MITER); //两条线的拐角为夹角
        paint.setStrokeJoin(Paint.Join.ROUND); //两条线的拐角为圆形
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStrokeCap(Paint.Cap.ROUND);
        Path path = new Path();
        path.moveTo(100, 100);
        path.lineTo(200, 100);
        canvas.drawPath(path, paint);

        paint.setStrokeCap(Paint.Cap.SQUARE);
        Path path1 = new Path();
        path1.moveTo(100, 200);
        path1.lineTo(200, 200);
        canvas.drawPath(path1, paint);

        paint.setStrokeCap(Paint.Cap.BUTT);
        Path path2 = new Path();
        path2.moveTo(100, 300);
        path2.lineTo(200, 300);
        canvas.drawPath(path2, paint);



//        paint.setStrokeJoin(Paint.Join.BEVEL);
//        Path path = new Path();
//        path.moveTo(100, 100);
//        path.lineTo(400, 100);
//        path.lineTo(400, 400);
//        canvas.drawPath(path, paint);
//
//        paint.setStrokeJoin(Paint.Join.MITER);
//        Path path1 = new Path();
//        path1.moveTo(100, 500);
//        path1.lineTo(400, 500);
//        path1.lineTo(400, 800);
//        canvas.drawPath(path1, paint);
//
//        paint.setStrokeJoin(Paint.Join.ROUND);
//        Path path2 = new Path();
//        path2.moveTo(100, 900);
//        path2.lineTo(400, 900);
//        path2.lineTo(400, 1200);
//        canvas.drawPath(path2, paint);
    }

}
