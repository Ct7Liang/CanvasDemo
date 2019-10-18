package com.android.ct7liang.canvasdemo.paint;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class PaintView1 extends View {

    private Paint paint;

    public PaintView1(Context context) {
        super(context);
    }

    public PaintView1(Context context, AttributeSet attrs) {
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
//        paint.setStrokeJoin(Paint.Join.BEVEL); //两条线的拐角是平的
//        paint.setStrokeJoin(Paint.Join.MITER); //两条线的拐角为夹角
        paint.setStrokeJoin(Paint.Join.ROUND); //两条线的拐角为圆形

        //设置笔画的倾斜度(没有效果)
        paint.setStrokeMiter(30);


        //普通设置
        paint.setStrokeWidth (50);//设置画笔宽度
        paint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
        paint.setStyle(Paint.Style.FILL);//绘图样式，对于设文字和几何图形都有效
        paint.setTextAlign(Paint.Align.CENTER);//设置文字对齐方式，取值：align.CENTER、align.LEFT或align.RIGHT
        paint.setTextSize(12);//设置文字大小

        //样式设置
        paint.setFakeBoldText(true);//设置是否为粗体文字
        paint.setUnderlineText(true);//设置下划线
        paint.setTextSkewX((float) -0.25);//设置字体水平倾斜度，普通斜体字是-0.25,正为向左倾斜,负则为向右倾斜
        paint.setStrikeThruText(true);//设置带有删除线效果

        //其它设置
        paint.setTextScaleX(2);//只会将水平方向拉伸，高度不会变

    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path path = new Path();
        path.moveTo(0, 0);
        path.lineTo(200, 300);
        path.lineTo(500, 100);
        path.lineTo(650, 700);
        path.lineTo(800, 500);
        path.lineTo(950, 800);
        path.lineTo(1080, 750);


        float[] ps = {
                100, 100, 500, 500,
                500, 500, 300, 700
        };

        canvas.drawLines(ps, paint);


//        //设置路径样式: 圆形拐角
//        //参数一: 拐角处圆形的半径,数值越大,圆形拐角越明显
//        paint.setPathEffect(new CornerPathEffect(30));
//        canvas.drawPath(path, paint);
//        paint.setColor(Color.RED);
//        paint.setPathEffect(new CornerPathEffect(120));
//        canvas.drawPath(path, paint);


//        float[] intervals = {20, 10, 40, 20};
//        //设置路径样式: 虚线效果
//        //参数一: 数组长度必须不小于2,且为偶数,奇数则忽略最后一个,依次代表实线,虚线的长度,然后循环组成虚线
//        //参数二: 偏移值,数组为虚线的组成单位,偏移值则为从这个单位的哪一个点开始
//        paint.setPathEffect(new DashPathEffect(intervals, 0));
//        paint.setPathEffect(new DashPathEffect(intervals, 30));
//        canvas.drawPath(path, paint);


//        //设置路径样式: 离散效果
//        //参数一: 用于控制离散点的数量,数值越大,离散点的数量越小
//        //参数二: 用于控制离散的分离成程度,数值越大,离散程度越大
//        paint.setPathEffect(new DiscretePathEffect(15, 15));
//        canvas.drawPath(path, paint);


//        Path path0 = new Path();
//        path0.moveTo(0, 0);
//        path0.lineTo(0, 40);
//        path0.lineTo(40, 40);
//        path0.close();
//        path0.addCircle(30, 10, 10, Path.Direction.CCW);
//        //设置路径样式: 印章效果
//        //参数一: 印章路径,另外的一个Path路径
//        //参数二: 印章间距,间距越小,印章重合度越大,当间距为0的时候,无印章
//        //参数三: 印章偏移量,同虚线的便宜量
//        //参数四: 表示在遇到拐角的时候，如何操作印章以使转角平滑过渡
////        PathDashPathEffect.Style.ROTATE - 旋转印章
//        //PathDashPathEffect.Style.TRANSLATE - 位移印章
//        //PathDashPathEffect.Style.MORPH - 改变印章形状
////        paint.setPathEffect(new PathDashPathEffect(path0, 50, 0, PathDashPathEffect.Style.ROTATE));
////        paint.setPathEffect(new PathDashPathEffect(path0, 50, 0, PathDashPathEffect.Style.TRANSLATE));
//        paint.setPathEffect(new PathDashPathEffect(path0, 50, 0, PathDashPathEffect.Style.MORPH));
//        canvas.drawPath(path, paint);


//        float[] intervals = {20, 10, 40, 20};
//        //设置路径样式: 组合路径
//        //这种组合方式为: 先将原始路径经过第二个样式的作用后,得到新的路径,最后在将新路径经过第一个样式的作用,最终得到新的组合路径
//        paint.setPathEffect(new ComposePathEffect(new DashPathEffect(intervals, 0), new DiscretePathEffect(15, 30)));
//        canvas.drawPath(path, paint);


//        float[] intervals = {20, 10, 40, 20};
//        //设置路径样式: 组合路径
//        //这种组合方式为: 原始路径分别经过两个样式的修改后,得到两种新的路径,然后再将这两个路径重合
//        paint.setPathEffect(new SumPathEffect(new DashPathEffect(intervals, 0), new DiscretePathEffect(15, 30)));
//        canvas.drawPath(path, paint);





//        paint.setStrokeCap(Paint.Cap.ROUND);
//        Path path = new Path();
//        path.moveTo(100, 100);
//        path.lineTo(200, 100);
//        canvas.drawPath(path, paint);
//
//        paint.setStrokeCap(Paint.Cap.SQUARE);
//        Path path1 = new Path();
//        path1.moveTo(100, 200);
//        path1.lineTo(200, 200);
//        canvas.drawPath(path1, paint);
//
//        paint.setStrokeCap(Paint.Cap.BUTT);
//        Path path2 = new Path();
//        path2.moveTo(100, 300);
//        path2.lineTo(200, 300);
//        canvas.drawPath(path2, paint);



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
