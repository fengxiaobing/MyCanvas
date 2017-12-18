package com.bing.mycanvas.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/12/18.
 */

public class MyClipView extends View{
    private Paint paint;
    public MyClipView(Context context) {
        super(context);
    }

    public MyClipView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);
        canvas.clipRect(100,100,800,800);
        canvas.drawColor(Color.YELLOW);
      /*  //Region.Op.DIFFERENCE 绘制与第一次不重叠的区域
        canvas.clipRect(300,300,600,600, Region.Op.DIFFERENCE);*/
      //显示第二次裁剪的区域
        canvas.clipRect(300,300,900,600, Region.Op.REPLACE);
/*   //显示第二次与第一次的重叠区域
        canvas.clipRect(300,300,900,600, Region.Op.INTERSECT);*/

        canvas.drawColor(Color.RED);

    }
}
