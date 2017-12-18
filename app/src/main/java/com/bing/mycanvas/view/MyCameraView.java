package com.bing.mycanvas.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.bing.mycanvas.R;

/**
 * Created by Administrator on 2017/12/18.
 */

public class MyCameraView extends View{
    private Paint paint;
    private Camera camera;
    private ObjectAnimator animator;
    private int degree;
    Point point;
private Bitmap bitmap;
    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
        invalidate();
    }

    public MyCameraView(Context context) {
        super(context);
    }

    public MyCameraView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        camera = new Camera();
        point = new Point(200,200);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        animator = ObjectAnimator.ofInt(this,"degree",1,180);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(3000);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int centerX = point.x+bitmap.getWidth()/2;
        int centerY = point.y+bitmap.getHeight()/2;

        camera.save();
        canvas.save();
        camera.rotateZ(degree);
        canvas.translate(centerX,centerY);
        camera.applyToCanvas(canvas);
        canvas.translate(-centerX,-centerY);
        camera.restore();
        canvas.drawBitmap(bitmap,point.x,point.y,paint);

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
