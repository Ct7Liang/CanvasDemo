package com.android.ct7liang.canvasdemo.newView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.android.ct7liang.canvasdemo.bean.Point;
import com.android.ct7liang.canvasdemo.utils.Count;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SignView extends View {

    private Paint paint;
    private Path path;

    private Bitmap bitmap;
    private Canvas bitmapCanvas;

    private ArrayList<Point> pList = new ArrayList<>();
    private ArrayList<Point> pcList = new ArrayList<>();

    public SignView(Context context) {
        super(context);
    }

    public SignView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(8);
        paint.setDither(false);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);

        path = new Path();
    }

    public SignView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (bitmap == null){
            bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            bitmapCanvas = new Canvas(bitmap);
        }

        canvas.drawBitmap(bitmap, 0, 0, paint);

//        canvas.drawPath(path, paint);
    }

    private float lastX;
    private float lastY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                pList.clear();
                break;

            case MotionEvent.ACTION_MOVE:

                if (lastX!=0&&lastY!=0){
                    double powX = Math.pow(lastX - event.getX(), 2);
                    double powY = Math.pow(lastY - event.getY(), 2);
                    double sqrt = Math.sqrt(powX + powY);

                    if (sqrt>100){
                        paint.setStrokeWidth(4);
                    }else if (sqrt>50){
                        paint.setStrokeWidth(6);
                    }else{
                        paint.setStrokeWidth(9);
                    }
                }
                lastX = event.getX();
                lastY = event.getY();

                int historySize = event.getHistorySize();
                for (int i = 0; i < historySize; i++) {
                    Count.drawPathByNewPoint(event.getHistoricalX(i), event.getHistoricalY(i), pList, bitmapCanvas, paint);
                }
                invalidate();
                break;

            case MotionEvent.ACTION_UP:
                lastX = 0;
                lastY = 0;
                break;
        }
        return true;
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                pList.clear();
//                break;
//
//            case MotionEvent.ACTION_MOVE:
//                int historySize = event.getHistorySize();
//                for (int i = 0; i < historySize; i++) {
//                    Count.drawPathByNewPoint(event.getHistoricalX(i), event.getHistoricalY(i), pList, bitmapCanvas, paint);
//                }
//                invalidate();
//                break;
//
//            case MotionEvent.ACTION_UP:
//
//                break;
//        }
//        return true;
//    }


//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                pList.clear();
//                break;
//
//            case MotionEvent.ACTION_MOVE:
//                int historySize = event.getHistorySize();
//                for (int i = 0; i < historySize; i++) {
//                    Count.drawPathByNewPoint(event.getHistoricalX(i), event.getHistoricalY(i), pList, path);
//                }
//                invalidate();
//                break;
//
//            case MotionEvent.ACTION_UP:
//
//                break;
//        }
//        return true;
//    }


    public void clear(){
//        path.reset();
        bitmap=null;
        invalidate();
    }


    public void save(){
//        File file=new File("/storage/emulated/0/1234.jpg");//将要保存图片的路径
        File file=new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis()+".jpg");//将要保存图片的路径
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("ct7liang123", e.toString());
        }
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                path.moveTo(event.getX(), event.getY());
//                break;
//            case MotionEvent.ACTION_MOVE:
//                int historySize = event.getHistorySize();
//                Log.i("ct7liang123", "move: " + historySize);
//                for (int i = 0; i < historySize; i++) {
//                    float historicalX = event.getHistoricalX(i);
//                    float historicalY = event.getHistoricalY(i);
//                    path.lineTo(historicalX, historicalY);
//                }
//                invalidate();
//                break;
//            case MotionEvent.ACTION_UP:
//
//                break;
//        }
//        return true;
//    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                pList.clear();
//                pList.add(new Point(event.getX(), event.getY()));
//                path.moveTo(event.getX(), event.getY());
//                break;
//            case MotionEvent.ACTION_MOVE:
//                int historySize = event.getHistorySize();
//                Log.i("ct7liang456", historySize+"");
//                for (int i = 0; i < historySize; i++) {
//                    pList.add(new Point(event.getHistoricalX(i), event.getHistoricalY(i)));
//                    path.lineTo(event.getHistoricalX(i), event.getHistoricalY(i));
//                }
//                Log.i("ct7liang123", pList.size()+"");
//                invalidate();
//                break;
//            case MotionEvent.ACTION_UP:
//
//                break;
//        }
//        return true;
//    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                pList.clear();
//                pcList.clear();
//                pList.add(new Point(event.getX(), event.getY()));
//                path.moveTo(event.getX(), event.getY());
//                break;
//            case MotionEvent.ACTION_MOVE:
//            case MotionEvent.ACTION_UP:
//
//                pList.add(new Point(event.getX(), event.getY()));
//
//                int size = pList.size();
//
//                if (size==3){
//                    //画二阶贝塞尔曲线
//                    Count.getControlPoints(pList, pcList);
//
//                    Point point1 = pList.get(0);
//                    Point pointc = pcList.get(0);
//                    Point point2 = pList.get(1);
//
//                    path.moveTo(point1.x, point1.y);
//                    path.quadTo(pointc.x, pointc.y, point2.x, point2.y);
//
//                    invalidate();
//                }
//                if (size>3){
//                    //画三阶贝塞尔曲线
//                    Count.getControlPoints(pList, pcList);
//
//                    Point point1 = pList.get((size - 2) / 2);
//                    Point point2 = pList.get((size - 2) / 2 + 1);
//                    Point pointc1 = pcList.get(size - 3);
//                    Point pointc2 = pcList.get(size - 2);
//
//                    path.moveTo(point1.x, point1.y);
//                    path.cubicTo(pointc1.x, pointc1.y, pointc2.x, pointc2.y, point2.x, point2.y);
//
//                    invalidate();
//                }
//                break;
//
//        }
//        return true;
//    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                pList.clear();
//                pcList.clear();
//                path.moveTo(event.getX(), event.getY());
//                break;
//
//            case MotionEvent.ACTION_MOVE:
//                for (int i = 0; i < event.getHistorySize(); i++) {
//                    pList.add(new Point(event.getHistoricalX(i), event.getHistoricalY(i)));
//                }
//                break;
//
//            case MotionEvent.ACTION_UP:
//                Count.getControlPoints0(pList, pcList);
//                Count.drawPath(path, pList, pcList);
//                invalidate();
//                break;
//        }
//        return true;
//    }

}
