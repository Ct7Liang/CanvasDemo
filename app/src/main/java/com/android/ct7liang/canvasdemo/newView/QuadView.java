package com.android.ct7liang.canvasdemo.newView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.android.ct7liang.canvasdemo.bean.Point;
import com.android.ct7liang.canvasdemo.utils.Count;

import java.util.ArrayList;

public class QuadView extends View {

    private Paint paint0;
    private Paint paint;
    private Path path;
    private ArrayList<Point> list1 = new ArrayList<>();
    private ArrayList<Point> list2 = new ArrayList<>();

    public QuadView(Context context) {
        super(context);
    }

    public QuadView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);

        paint0 = new Paint();
        paint0.setColor(Color.BLACK);
        paint0.setStyle(Paint.Style.STROKE);
        paint0.setStrokeWidth(16);

        list1.add(new Point(100, 600));
        list1.add(new Point(250, 200));
        list1.add(new Point(400, 500));
        list1.add(new Point(550, 900));
        list1.add(new Point(700, 200));
        list1.add(new Point(800, 570));
        list1.add(new Point(900, 600));
        list1.add(new Point(1000, 300));

        path = new Path();
    }

    public QuadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < list1.size(); i++) {
            canvas.drawPoint(list1.get(i).x, list1.get(i).y, paint0);
        }

        Count.getControlPoints0(list1, list2);

        Count.drawPath(path, list1, list2);

        canvas.drawPath(path, paint);

//        path.moveTo(list1.get(0).x, list1.get(0).y);
//        path.quadTo(list2.get(0).x, list2.get(0).y, list1.get(1).x, list1.get(1).y);
//        canvas.drawPath(path, paint);
//
//
//        for (int i = 0; i < 5; i++) {
//            path.moveTo(list1.get(i+1).x, list1.get(i+1).y);
//            path.cubicTo(
//                    list2.get(i*2+1).x, list2.get(i*2+1).y,
//                    list2.get(i*2+2).x, list2.get(i*2+2).y,
//                    list1.get(i+2).x, list1.get(i+2).y
//            );
//
//            canvas.drawPath(path, paint);
//        }
//
//
//        path.moveTo(list1.get(6).x, list1.get(6).y);
//        path.quadTo(list2.get(11).x, list2.get(11).y, list1.get(7).x, list1.get(7).y);
//        canvas.drawPath(path, paint);
    }
}
