package com.android.ct7liang.canvasdemo.newView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

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
        paint.setDither(true);
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
            bitmapCanvas.drawColor(Color.WHITE);
        }
        canvas.drawBitmap(bitmap, 0, 0, paint);

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
                        paint.setStrokeWidth(5);
                    }else if (sqrt>95){
                        paint.setStrokeWidth(5.5f);
                    }else if (sqrt>90){
                        paint.setStrokeWidth(6);
                    }else if (sqrt>85){
                        paint.setStrokeWidth(6.5f);
                    }else if (sqrt>80){
                        paint.setStrokeWidth(7);
                    }else if (sqrt>75){
                        paint.setStrokeWidth(7.5f);
                    }else if (sqrt>70){
                        paint.setStrokeWidth(8);
                    }else if (sqrt>65){
                        paint.setStrokeWidth(8.5f);
                    }else {
                        paint.setStrokeWidth(9);
                    }

                }
                lastX = event.getX();
                lastY = event.getY();

//                Count.drawPathByNewPoint(lastX, lastY, pList, bitmapCanvas, paint);
//                invalidate();


                int historySize = event.getHistorySize();
                for (int i = 0; i < historySize; i++) {

//                    switch (i){
//                        case 0:
//                            paint.setColor(Color.BLACK);
//                            break;
//                        case 1:
//                            paint.setColor(Color.YELLOW);
//                            break;
//                        case 2:
//                            paint.setColor(Color.BLUE);
//                            break;
//                        case 3:
//                            paint.setColor(Color.GREEN);
//                            break;
//                        case 4:
//                            paint.setColor(Color.RED);
//                            break;
//                        case 5:
//                            paint.setColor(Color.BLACK);
//                            break;
//                        case 6:
//                            paint.setColor(Color.YELLOW);
//                            break;
//                        case 7:
//                            paint.setColor(Color.BLUE);
//                            break;
//                        case 8:
//                            paint.setColor(Color.GREEN);
//                            break;
//                        case 9:
//                            paint.setColor(Color.RED);
//                            break;
//                    }

                    Count.drawPathByNewPoint(event.getHistoricalX(i), event.getHistoricalY(i), pList, bitmapCanvas, paint);
                    invalidate();
                }

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





    public void clear(){
//        path.reset();
        bitmap=null;
        invalidate();
    }


    public void save(){
//        File file=new File("/storage/emulated/0/1234.jpg");//将要保存图片的路径
        File file=new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis()+".jpg");//将要保存图片的路径
        try {
            bitmapCanvas.save();
            bitmapCanvas.restore();

            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
            Toast.makeText(getContext(), "图片保存成功", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
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







}
