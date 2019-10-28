package com.android.ct7liang.canvasdemo.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
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

//        paint.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(8);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setTextSize(120);

//        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);

        Path path = new Path();

        path.addCircle(400, 400, 250, Path.Direction.CCW);
        path.addCircle(600, 400, 250, Path.Direction.CCW);
//        path.setFillType(Path.FillType.EVEN_ODD); //重叠区域无填充
//        path.setFillType(Path.FillType.INVERSE_EVEN_ODD); //重叠区域填充
//        path.setFillType(Path.FillType.WINDING); //全部填充
//        path.setFillType(Path.FillType.INVERSE_WINDING); //全部无填充


        canvas.drawPath(path, paint);

        canvas.drawLine(100, 100, 700, 700, paint);



//        path3.reset();

//        path3.rewind();
//
    }
}
