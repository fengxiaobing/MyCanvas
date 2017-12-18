package com.bing.mycanvas.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/12/18.
 */

public class MyPicture extends View {

    private Picture picture;
    private Paint paint;

    public MyPicture(Context context) {
        super(context);
    }

    public MyPicture(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        picture = new Picture();

        // 记得先创建一个画笔
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas = picture.beginRecording(500,500);
        // 位移
        // 将坐标系的原点移动到(450,650)
        canvas.translate(450,650);


        // 绘制一个圆
        // 圆心为（0，0），半径为100
        canvas.drawCircle(0,0,100,paint);

        picture.endRecording();
        canvas.drawPicture(picture, new RectF(0, 0, picture.getWidth(), 200));
    }
}
