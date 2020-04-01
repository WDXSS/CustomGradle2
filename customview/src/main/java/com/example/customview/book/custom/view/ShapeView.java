package com.example.customview.book.custom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.jetpack.DevDescribe;

@DevDescribe("创建Drawable 对象 ，调用Drawable 的draw()函数将Drawable 对象画到画布上")
public class ShapeView extends View {

    private ShapeDrawable mRectShapeDrawable;
    private ShapeDrawable mArcShapeDrawable;
    private ShapeDrawable mOvalShapeDrawable;
    private ShapeDrawable mRoundRectShapeDrawable;
    private ShapeDrawable mPathDrawable;

    public ShapeView(Context context) {
        super(context);
        initRect();
        initArcShape();
        initOvalShape();
        initRoundRectShape();
    }

    public ShapeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initRect();
        initArcShape();
        initOvalShape();
        initRoundRectShape();
    }

    public ShapeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initRect();
        initArcShape();
        initOvalShape();
        initRoundRectShape();
    }

    public ShapeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initRect();
        initArcShape();
        initOvalShape();
        initRoundRectShape();
    }

    @DevDescribe("矩形")
    private void initRect() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        //ShapeDrawable 对象需要指定个 一个shape 类型
        RectShape rectShape = new RectShape();
        //ShapeDrawable 设置Shape 两种方式，1.构造方法，2.set 函数 setShape(rectShape)
        mRectShapeDrawable = new ShapeDrawable(rectShape);
        //为Drawable指定一个边框。当调用draw()方法时，drawable将在这里绘制。
        mRectShapeDrawable.setBounds(new Rect(50, 50, 200, 100));
        mRectShapeDrawable.getPaint().setColor(Color.GREEN);

    }

    @DevDescribe("画一个扇形")
    private void initArcShape() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        //ArcShape 画一个扇形，
        // 参数：startAngle 开始是的角度，
        //       sweepAngle  扫过的角度
        ArcShape arcShape = new ArcShape(0, 270);
        mArcShapeDrawable = new ShapeDrawable();
        mArcShapeDrawable.setShape(arcShape);//设置 shape ，
        mArcShapeDrawable.setBounds(50, 150, 200, 200);
        mArcShapeDrawable.getPaint().setColor(Color.RED);
    }

    @DevDescribe("画一个椭圆")
    private void initOvalShape() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);

        OvalShape arcShape = new OvalShape();
        mOvalShapeDrawable = new ShapeDrawable();
        mOvalShapeDrawable.setShape(arcShape);//设置 shape ，
        mOvalShapeDrawable.setBounds(50, 250, 200, 300);
        mOvalShapeDrawable.getPaint().setColor(Color.GRAY);
    }

    @DevDescribe("构造一个圆角 shape， 可以带有镂空矩形效果")
    private void initRoundRectShape() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        //RoundRectShape 构造参数 ：
//        float[] outerRadii  需要填充8个数字，每两个为一组：标记外部四个角的角度(左上角，右上角，右下角，左下角)  第一个数字表示椭圆的X半径，第二个表示Y半径
//        RectF inset 表示内部矩形与外部矩形各边的边距，( left,  top,  right,  bottom)，不需要内矩形镂空效果传入null
//        float[] innerRadii  内矩形的四个角度

        float[] outerRadii = new float[]{12, 12, 1, 12, 0, 0, 0, 0};
        RectF rectF = new RectF(9, 18, 9, 18);
        float[] innerRadii = new float[]{50, 25, 0, 0, 25, 50, 0, 0};
        RoundRectShape roundRectShape = new RoundRectShape(outerRadii, rectF, innerRadii);
        mRoundRectShapeDrawable = new ShapeDrawable(roundRectShape);
        mRoundRectShapeDrawable.setBounds(new Rect(50, 350, 400, 550));
        mRoundRectShapeDrawable.getPaint().setColor(Color.BLUE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mRectShapeDrawable.draw(canvas);
        mArcShapeDrawable.draw(canvas);
        mOvalShapeDrawable.draw(canvas);
        mRoundRectShapeDrawable.draw(canvas);
    }
}
