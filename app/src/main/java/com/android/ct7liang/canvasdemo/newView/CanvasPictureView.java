package com.android.ct7liang.canvasdemo.newView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import android.util.AttributeSet;
import android.view.View;

import com.android.ct7liang.canvasdemo.R;


/**
 * Picture和录像功能是类似的，只不过Picture录的是Canvas中绘制的内容。
 * 我们把Canvas绘制点，线，矩形等诸多操作用Picture录制下来，下次需要的时候拿来就能用，
 * 使用Picture相比于再次调用绘图API，开销是比较小的，也就是说对于重复的操作可以更加效率。
 */
public class CanvasPictureView extends View {

    private Bitmap bitmap;
    private Picture picture;

    public CanvasPictureView(Context context) {
        super(context);
    }

    public CanvasPictureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //注意:关闭硬件加速器
        setLayerType(LAYER_TYPE_SOFTWARE, null);

        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.p1);
        picture = new Picture();

        Canvas canvas = picture.beginRecording(500, 500);
        canvas.drawBitmap(bitmap, 100, 100, null);
        picture.endRecording();
    }

    public CanvasPictureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPicture(picture);

        canvas.drawPicture(picture, new RectF(0, 0, 300, 300));

        PictureDrawable pictureDrawable = new PictureDrawable(picture);

        pictureDrawable.setBounds(0, 0, 200, picture.getHeight());

        pictureDrawable.draw(canvas);
    }
}
