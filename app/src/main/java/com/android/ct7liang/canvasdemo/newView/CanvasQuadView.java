package com.android.ct7liang.canvasdemo.newView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class CanvasQuadView extends View {

    private Paint paint;
    private Path path;
    private Path path2;
    private Path path3;

    public CanvasQuadView(Context context) {
        super(context);
    }

    public CanvasQuadView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(3);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);

        path = new Path();
        path.moveTo(200, 200);
        path.rQuadTo(600, 600, 400, 1000);

        path2 = new Path();
        path2.moveTo(200, 200);
        path2.cubicTo(800, 200, 800, 650, 400, 1000);


        path3 = new Path();
        path3.moveTo(200, 1200);
        path3.cubicTo(500, 1200, 800, 900, 1000, 800);

    }

    public CanvasQuadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(path, paint);

        canvas.drawPath(path2, paint);

        canvas.drawPath(path3, paint);
    }
}
