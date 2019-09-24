package com.android.ct7liang.canvasdemo.newView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CanvasView extends View {

    private Paint paint;

    public CanvasView(Context context) {
        super(context);
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setAntiAlias(true); //设置画笔是否抗锯齿
        paint.setColor(Color.RED); //设置画笔颜色

    }

    public CanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        paint.setColor(Color.parseColor("#CCCCCC"));

        canvas.drawColor(Color.parseColor("#FFFFFF"));

        paint.setColor(Color.BLACK);

        paint.setTextSize(50); //设置文字大小
//        paint.setTextAlign(Paint.Align.RIGHT);
        paint.setTextScaleX(1f); //设置文字横向拉伸度

        Paint.FontMetrics fontMetrics = paint.getFontMetrics();


//        char[] texts = {'临', '兵', '斗', '者', ',', '皆', '阵', '列', '在', '前', '?', '?'};
//        canvas.drawText(texts, 0, 10, 0, 0, paint);
//
//        canvas.drawText(texts, 0, 10, 0, Math.abs(fontMetrics.top), paint);
//
//
//        canvas.drawText("最肯忘却古人诗", 240, 240, paint);
//
//        canvas.drawText("最肯忘却古人诗,最不屑一顾是相思", 8, 16, 120, 360, paint);

        float top = fontMetrics.top;
        float ascent = fontMetrics.ascent;

        Log.i("ct7liang123", "top: " + top + ", ascent: " + ascent);

        float bottom = fontMetrics.bottom;
        float descent = fontMetrics.descent;
        Log.i("ct7liang123", "bottom: " + bottom + ", descent: " + descent);



        canvas.drawText("自定义控件", 0, 0, paint);

        String s = "自定义控件";

        canvas.drawText("自定义控件", paint.measureText(s), Math.abs(fontMetrics.top), paint);

        Log.i("ct7liang123", "width: " + paint.measureText(s));


//        //画矩形
//        paint.setStrokeWidth(8); //设置矩形边界的宽度
//
//        paint.setStyle(Paint.Style.FILL); //绘制方式: 填充
//        paint.setStyle(Paint.Style.STROKE); //绘制方式: 描边
//        paint.setStyle(Paint.Style.FILL_AND_STROKE); //绘制方式: 填充+描边
//
//        canvas.drawCircle(500, 400, 250, paint);



        //画矩形
//        paint.setStrokeWidth(8); //设置矩形边界的宽度
//
//        paint.setStyle(Paint.Style.FILL); //绘制方式: 填充
//        paint.setStyle(Paint.Style.STROKE); //绘制方式: 描边
//        paint.setStyle(Paint.Style.FILL_AND_STROKE); //绘制方式: 填充+描边

//        canvas.drawRect(50, 100, 800, 500, paint);
//
//        @SuppressLint("DrawAllocation")
//        Rect rect = new Rect(60, 550, 700, 850);
//        canvas.drawRect(rect, paint);
//
//        @SuppressLint("DrawAllocation")
//        RectF rectF = new RectF(60.5f, 900.5f, 700.5f, 1300.5f);
//        canvas.drawRect(rectF, paint);

        //画圆角矩形
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//
//            canvas.drawRoundRect(50, 100, 800, 500, 8, 8, paint);
//
//            @SuppressLint("DrawAllocation")
//            RectF rectF = new RectF(60.5f, 900.5f, 700.5f, 1300.5f);
//            canvas.drawRoundRect(rectF, 10, 10, paint);
//        }

//        //画直线
//        paint.setStrokeWidth(8); //设置线的宽度
//
//        canvas.drawLine(30, 60, 400, 90, paint);
//
//        float[] points1 = {116, 212, 123, 234,  145, 156, 267, 178,  289, 190, 287, 154};
//        //四个坐标确定一条直线,points1可以画出三条线
//        canvas.drawLines(points1, paint);
//
//        float[] points2 = {116, 312, 123, 334,  145, 256, 267, 278,  289, 290, 287, 254};
//        //第二个参数(offset)表示偏移值, 第三个参数(count)代表读取的坐标的数量
//        canvas.drawLines(points2, 4, 4, paint);



//        //画点
//        paint.setStrokeWidth(8); //设置点的大小
//        canvas.drawPoint(900, 900, paint);
//
//        float[] points1 = {16, 12, 23, 34, 45, 56, 67, 78, 89, 90, 87, 54, 28, 68};
//        canvas.drawPoints(points1, paint);
//
//        float[] points2 = {16, 212, 23, 234, 45, 256, 67, 278, 89, 290, 87, 254, 28, 268};
//        //第二个参数(offset)表示偏移值, 第三个参数(count)代表读取的值的数量
//        canvas.drawPoints(points2, 2, 10, paint);

    }
}
