package com.example.book_custom._9view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.book_custom.DevDescribe;

@DevDescribe("新的Api 已经不支持 canvas.save(Canvas.MATRIX_SAVE_FLAG); 中的入参 Canvas.MATRIX_SAVE_FLAG" +
        "对画布进行旋转 ")
public class CanvasFlag_MatrixView extends View {
    private Paint mPaint;
    public CanvasFlag_MatrixView(Context context) {
        this(context, null);
    }

    public CanvasFlag_MatrixView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
//       总结：
//       1. Canvas.MATRIX_SAVE_FLAG 标识只会保存位置矩阵，在恢复时也只会恢复画布的位置，
//           除此之外的任何信息（比如 画布大小）都不会恢复；save()和saveLayer()函数相同;
//       2. saveLayer()函数在使用用Canvas.MATRIX_SAVE_FLAG 标识时需要与 Canvas.HAS_ALPHA_LAYER_SAVE_FLAG
//           标识一起使用，否则新建的画布所在区域原来的图像将被清空



//
    }

    public CanvasFlag_MatrixView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint = new Paint();

        mPaint.setColor(Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //首先调用 canvas.save(Canvas.MATRIX_SAVE_FLAG);函数将 Canvas 的位置矩阵保存起来；
        //然后将画布旋转40度，画一个灰色的矩形；
        //接着调用 canvas.restore(); 函数将画布恢复；
        //最后在同一位置画一个黑色矩形
        // 证明：canvas.save(Canvas.MATRIX_SAVE_FLAG) 只会保存位置矩阵，恢复是只恢复矩阵位置，其他任何信息都不恢复
//        canvas.save(Canvas.MATRIX_SAVE_FLAG);
        canvas.save();
        canvas.rotate(40);
        canvas.drawRect(100,0,200,100,mPaint);
        canvas.restore();

        mPaint.setColor(Color.BLACK);
        canvas.drawRect(100,0,200,100,mPaint);

        //对画布进行裁决
        //先对画布进行保存 canvas.save(Canvas.MATRIX_SAVE_FLAG);
        //然后将画布裁剪成一个矩形，将画布绘制成灰色
        //恢复画布，
        //将画布绘制成黑色
        //结果:只有裁剪的部分被染成了黑色，再次证明 canvas.save(Canvas.MATRIX_SAVE_FLAG) 只会保存位置矩阵，恢复是只恢复矩阵位置，其他任何信息都不恢复(包括画布大小)
//        canvas.save(Canvas.MATRIX_SAVE_FLAG);
//        canvas.clipRect(100, 0, 200, 100);
//        canvas.drawColor(Color.GRAY);
//        canvas.restore();
//        canvas.drawColor(Color.BLACK);
    }
}
