package com.android.ct7liang.canvasdemo.newView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CanvasTextView extends View {

    private Paint paint;
    private TextPaint textPaint;

    private static final String TEXT = "不乱于心,不困于情,不念过去,不畏将来";

    public CanvasTextView(Context context) {
        super(context);
    }

    public CanvasTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setAntiAlias(true); //设置画笔是否抗锯齿
        paint.setColor(Color.RED); //设置画笔颜色

        textPaint = new TextPaint();
        textPaint.setAntiAlias(true); //设置画笔是否抗锯齿
        textPaint.setColor(Color.BLACK); //设置画笔颜色
        textPaint.setTextSize(40); //设置文字的大小，但是要注意该值必需大于零。
        textPaint.setUnderlineText(true); //设置下划线


        //设置文本在水平方向上的倾斜。这个倾斜值没有具体的范围，但是官方推崇的值为-0.25可以得到比较好的倾斜文本效果，值为负右倾值为正左倾，默认值为0。
        textPaint.setTextSkewX(-0.25f);

        //将文本沿X轴水平缩放，默认值为1，当值大于1会沿X轴水平放大文本，当值小于1会沿X轴水平缩放文本
        textPaint.setTextScaleX(0.5f);

        //设置文本的对齐方式，可供选的方式有三种：CENTER,LEFT和RIGHT。
        //这个Align就是为我们定义在baseline绘制文本究竟该从何处开始
        textPaint.setTextAlign(Paint.Align.LEFT);

        //文本删除线
        textPaint.setStrikeThruText(true);

        //设置文本仿粗体
        textPaint.setFakeBoldText(true);

        //测量文本宽度
        float v = textPaint.measureText(TEXT);



        textPaint.setTypeface(Typeface.DEFAULT_BOLD); //设置字体
        textPaint.setTypeface(Typeface.DEFAULT);
        textPaint.setTypeface(Typeface.MONOSPACE);
        textPaint.setTypeface(Typeface.SANS_SERIF);
        textPaint.setTypeface(Typeface.SERIF);

        textPaint.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        textPaint.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
        textPaint.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        textPaint.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));
    }

    public CanvasTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.parseColor("#FFFFFF"));

        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();

        Log.i("Aige", "ascent：" + fontMetrics.ascent + " - " + textPaint.ascent());
        Log.i("Aige", "top：" + fontMetrics.top);
        Log.i("Aige", "leading：" + fontMetrics.leading);
        Log.i("Aige", "descent：" + fontMetrics.descent + " - " + textPaint.descent());
        Log.i("Aige", "bottom：" + fontMetrics.bottom);


        textPaint.clearShadowLayer();



        canvas.drawText(TEXT, 0, 0, textPaint);


        textPaint.breakText(TEXT, true, 30, null);

        canvas.drawText(TEXT, 0, Math.abs(fontMetrics.top), textPaint);




//        // 绘制屏幕居中的文字
//        // 计算Baseline绘制的起点X轴坐标 ，计算方式：画布宽度的一半 - 文字宽度的一半
//        int baseX = (int) (getWidth() / 2 - textPaint.measureText(TEXT) / 2);
//        // 计算Baseline绘制的Y坐标 ，计算方式：画布高度的一半 - 文字总高度的一半
//        int baseY = (int) ((getHeight() / 2) - ((textPaint.descent() + Math.abs(textPaint.ascent())) / 2));
//        // 居中画一个文字
//        canvas.drawText(TEXT, baseX, baseY, textPaint);


    }
}
