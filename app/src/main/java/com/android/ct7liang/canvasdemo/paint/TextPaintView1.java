package com.android.ct7liang.canvasdemo.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class TextPaintView1 extends View {

    private Paint paint;

    public TextPaintView1(Context context) {
        super(context);
    }

    public TextPaintView1(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setTextSize(120);

//        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);

        paint.setShadowLayer(25, 50, 50, Color.GRAY);

        Path path = new Path();
        path.moveTo(0,500);
        path.lineTo(500, 750);

        canvas.drawPath(path, paint);

        canvas.drawText("AndroidDeveloper", 100, 300, paint);


        path.moveTo(500, 700); //绝对位置
        path.rMoveTo(500, 700); //相对位置
    }
}
