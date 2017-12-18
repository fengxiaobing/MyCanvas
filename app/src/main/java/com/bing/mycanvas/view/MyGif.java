package com.bing.mycanvas.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.bing.mycanvas.R;

/**
 * Created by Administrator on 2017/12/18.
 */

public class MyGif extends View {
    private Paint paint;
    private Bitmap bitmap;
    private ObjectAnimator animator;
    private int percent;

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
        invalidate();
    }

    public MyGif(Context context) {
        super(context);
    }

    public MyGif(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        animator = ObjectAnimator.ofInt(this,"percent",0,100);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setDuration(5000);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 参数（src，dst） = 两个矩形区域
// Rect src：指定需要绘制图片的区域（即要绘制图片的哪一部分）
// Rect dst 或RectF dst：指定图片在屏幕上显示(绘制)的区域
// 下面我将用实例来说明

// 实例
        // 指定图片绘制区域
        // 仅绘制图片的二分之一
        Rect src = new Rect(0,0,bitmap.getWidth()*percent/100,bitmap.getHeight()*percent/100);

//        Rect src = new Rect(bitmap.getWidth()*percent/100,bitmap.getHeight()*percent/100,bitmap.getWidth(),bitmap.getHeight());
//        Rect src = new Rect(0,100,bitmap.getWidth(),150);
        // 指定图片在屏幕上显示的区域
        Rect dst = new Rect(0,0,400,400);
        canvas.scale(1f, 1f, 200,200);
        // 绘制图片
        canvas.drawBitmap(bitmap,src,dst,null);

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        animator.start();
    }
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animator.end();
    }
}
