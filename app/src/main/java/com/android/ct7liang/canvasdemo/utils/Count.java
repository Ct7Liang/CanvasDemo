package com.android.ct7liang.canvasdemo.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;

import com.android.ct7liang.canvasdemo.bean.Point;

import java.util.ArrayList;

public class Count {

    public static void getControlPoints(ArrayList<Point> points, ArrayList<Point> controls){

        int size = points.size();

        Point p1 = points.get(size-3);
        Point p2 = points.get(size-2);
        Point p3 = points.get(size-1);

        Point p12 = new Point((p1.x+p2.x)/2, (p1.y+p2.y)/2);
        Point p23 = new Point((p2.x+p3.x)/2, (p2.y+p3.y)/2);

        float dy = (p12.y+p23.y)/2 - p2.y;

        Point c1 = new Point((p1.x+p2.x)/2, (p1.y+p2.y)/2-dy);
        Point c2 = new Point((p2.x+p3.x)/2, (p2.y+p3.y)/2-dy);

        controls.add(c1);
        controls.add(c2);
    }


    public static void getControlPoints0(ArrayList<Point> points, ArrayList<Point> controls){

        if (points.size()<3){
            return;
        }

        for (int i = 0; i < points.size() - 2; i++) {

            Point p1 = points.get(i);
            Point p2 = points.get(i+1);
            Point p3 = points.get(i+2);

            Point p12 = new Point((p1.x+p2.x)/2, (p1.y+p2.y)/2);
            Point p23 = new Point((p2.x+p3.x)/2, (p2.y+p3.y)/2);

            float dy = (p12.y+p23.y)/2 - p2.y;

            Point c1 = new Point((p1.x+p2.x)/2, (p1.y+p2.y)/2-dy);
            Point c2 = new Point((p2.x+p3.x)/2, (p2.y+p3.y)/2-dy);

            controls.add(c1);
            controls.add(c2);
        }
    }


    /**
     * 根据已有的点和控制点,描绘出贝塞尔路径
     * @param path
     * @param list1
     * @param list2
     */
    public static void drawPath(Path path, ArrayList<Point> list1, ArrayList<Point> list2){

        int size1 = list1.size();
        int size2 = list2.size();

        if (size2 != (size1-2)*2){
            return;
        }

        if (size1 < 2){
            return;
        }else if (size1 == 2){
            //画直线
            path.moveTo(list1.get(0).x, list1.get(0).y);
            path.lineTo(list1.get(1).x, list1.get(1).y);
        }else if (size1 == 3){
            //画两个贝塞尔曲线
            path.moveTo(list1.get(0).x, list1.get(0).y);
            path.quadTo(list2.get(0).x, list2.get(0).y, list1.get(1).x, list1.get(1).y);
            path.moveTo(list1.get(1).x, list1.get(1).y);
            path.quadTo(list2.get(1).x, list2.get(1).y, list1.get(2).x, list1.get(2).y);
        }else {
            //两端是二阶贝塞尔曲线, 中间是n个三阶贝塞尔曲线
            //首端二阶贝塞尔曲线
            path.moveTo(list1.get(0).x, list1.get(0).y);
            path.quadTo(list2.get(0).x, list2.get(0).y, list1.get(1).x, list1.get(1).y);

            //中间三阶贝塞尔曲线
            for (int i = 0; i < size1 - 3; i++) {
                path.moveTo(list1.get(i+1).x, list1.get(i+1).y);
                path.cubicTo(
                        list2.get(i*2+1).x, list2.get(i*2+1).y,
                        list2.get(i*2+2).x, list2.get(i*2+2).y,
                        list1.get(i+2).x, list1.get(i+2).y);
            }

            //末端二阶贝塞尔曲线
            path.moveTo(list1.get(size1-2).x, list1.get(size1-2).y);
            path.quadTo(list2.get(size2-1).x, list2.get(size2-1).y, list1.get(size1-1).x, list1.get(size1-1).y);
        }

    }



    private static Point[] controls = new Point[4];



    public static void drawPathByNewPoint(float x, float y, ArrayList<Point> list, Canvas canvas, Paint paint){
        Path path = new Path();
        list.add(new Point(x, y));
        countControls(list);
        int size = list.size();
//        Log.i("ct7liang123 size: ", "" + size);
        if (size == 3){
            path.moveTo(list.get(0).x, list.get(0).y);
            path.quadTo(controls[2].x, controls[2].y, list.get(1).x, list.get(1).y);
        }else if (size > 3){
            path.moveTo(list.get(size-3).x, list.get(size-3).y);
            path.cubicTo(
                    controls[1].x, controls[1].y,
                    controls[2].x, controls[2].y,
                    list.get(size-1).x, list.get(size-1).y
            );
            canvas.drawPath(path, paint);
        }

    }

    public static void drawPathByNewPoint(float x, float y, ArrayList<Point> list, Path path){
        list.add(new Point(x, y));
        countControls(list);
        int size = list.size();
        if (size == 3){
            path.moveTo(list.get(0).x, list.get(0).y);
            path.quadTo(controls[2].x, controls[2].y, list.get(1).x, list.get(1).y);
        }else if (size > 3){
            path.moveTo(list.get(size-3).x, list.get(size-3).y);
            path.cubicTo(
                    controls[1].x, controls[1].y,
                    controls[2].x, controls[2].y,
                    list.get(size-1).x, list.get(size-1).y
            );
        }

    }

    private static void countControls(ArrayList<Point> list){
        int size = list.size();
        if (size < 3){
            return;
        }
        controls[0] = controls[2];
        controls[1] = controls[3];

        Point p1 = list.get(size-3);
        Point p2 = list.get(size-2);
        Point p3 = list.get(size-1);
        Point p12 = new Point((p1.x+p2.x)/2, (p1.y+p2.y)/2);
        Point p23 = new Point((p2.x+p3.x)/2, (p2.y+p3.y)/2);
        float dy = (p12.y+p23.y)/2 - p2.y;
        Point c1 = new Point((p1.x+p2.x)/2, (p1.y+p2.y)/2-dy);
        Point c2 = new Point((p2.x+p3.x)/2, (p2.y+p3.y)/2-dy);

        controls[2] = c1;
        controls[3] = c2;
    }

}
