package com.android.ct7liang.canvasdemo.newView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.android.ct7liang.canvasdemo.R;

public class CanvasBitmapView extends View {

    private Paint paint;
    private Bitmap bitmap;

    public CanvasBitmapView(Context context) {
        super(context);
    }

    public CanvasBitmapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);

        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.p1);
    }

    public CanvasBitmapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //确定图片的左上角, 画出图片, 图片按照实际大小展示, 超出屏幕部分的图片不会显示
        canvas.drawBitmap(bitmap, 0, 0, paint);




//        //指定显示图片的哪一部分区域
//        Rect rectFSrc = new Rect(bitmap.getWidth()/3, bitmap.getHeight()/3, bitmap.getWidth()/3*2, bitmap.getHeight()/3*2);
//        //指定在屏幕的那一部分区域显示
//        Rect dst = new Rect(0, 0, canvas.getWidth()/3, canvas.getWidth()/3);
//        //显示图片
//        canvas.drawBitmap(bitmap, rectFSrc, dst, null);

//        //创建矩阵
//        Matrix matrix = new Matrix();
//        //设置矩阵变换类型
//        matrix.postTranslate(200, 200);
//        matrix.postRotate(45);
//        matrix.postScale(0.5f, 0.5f);
//        matrix.postScale(0.5f, 0.5f, bitmap.getWidth()/2, bitmap.getHeight()/2);
//        matrix.postSkew(0.5f, 0.5f);
//        matrix.postSkew(0.5f, 0.5f, bitmap.getWidth()/2, bitmap.getHeight()/2);
//        //显示图片
//        canvas.drawBitmap(bitmap, matrix, null);


    }
}
