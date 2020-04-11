package com.example.customview.book.custom._8xfermode.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("通过AvoidXfermode 修改颜色  AvoidXfermode 28 API 没有这个类了 參考Module myXfermode 的类")
public class AvoidXfermodeColorView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;

    public AvoidXfermodeColorView(Context context) {
        this(context, null);
    }

    public AvoidXfermodeColorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AvoidXfermodeColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);//设置画笔的颜色为红色
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = mBitmap.getWidth() / 2;
        int height = width * mBitmap.getHeight() / mBitmap.getWidth();

        //保存状态
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        //离屏绘制，将绘制代码全部放在 canvas.save() 和 canvas.restore() 之间

        //首先将图片缩放控件的一半并画出来
        canvas.drawBitmap(mBitmap, null, new Rect(0, 0, width, height), mPaint);
        //其次，设置Xfermode 找选区
        //参数：
//        int opColor 选取的颜色
//        int tolerance 容差值 应为 颜色的取值范围是 0~255， 所以取值范围是0到255， 取255是所有颜色将被覆盖
//        Mode mode 选取模式：Mode.TARGET表示将制定颜色 ,
//                           Mode.AVOID 表示将Mode.TARGET 的相反区域颜色替换掉
//        AvoidXfermode avoidXfermode = new AvoidXfermode(Color.WHITE,100, AvoidXfermode.Mode.AVOID);
        //最后：将对应选区的图像画到画布上
        canvas.drawRect(0,0,width,height,mPaint);

        //离屏绘制，将绘制代码全部放在 canvas.save() 和 canvas.restore() 之间
        canvas.restoreToCount(layerId);
    }
}
