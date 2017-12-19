package com.bing.mycanvas.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by RF
 * on 2017/12/18.
 */

public class MyTextView extends View {
   private Paint paint;
   private Path path;
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.BLUE);
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 2. 设置路径轨迹
        path.quadTo(540, 750, 640, 650);
        // 3. 画路径
        paint.setTextSize(30);
        canvas.drawTextOnPath("啊哈哈哈哈哈哈哈哈啊哈哈哈哈哈哈哈哈啊哈哈哈哈哈哈哈哈啊哈哈哈哈哈哈哈哈",path,50,0,paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path,paint);
    }
}
