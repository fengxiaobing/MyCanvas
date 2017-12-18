package com.bing.mycanvas.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by RF
 * on 2017/12/18.
 */

public class MyRect extends View {
    private Paint paint;
    public MyRect(Context context) {
        super(context);
    }

    public MyRect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(100,100,300,300,paint);
        canvas.translate(100,200);
        canvas.drawRect(100,100,300,300,paint);
      /*  //绘制圆角矩形
        canvas.drawRoundRect(500,500,800,700,100,150,paint);*/
        //绘制椭圆(其实就是画一个矩形的内切圆)
        canvas.drawOval(500,500,800,700,paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(500,500,800,700,paint);
    }
}
