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
public class PathShapeView extends View {
    private ShapeDrawable mPathDrawable;

    public PathShapeView(Context context) {
        super(context);
        initPathShape();
    }

    public PathShapeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initPathShape();
    }

    public PathShapeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initPathShape();
    }

    public PathShapeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        initPathShape();
    }

    private void initPathShape() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        Path path = new Path();
//        path.moveTo(50,500);
//        path.lineTo(100,500);
//        path.lineTo(100,550);
        path.moveTo(0, 0);
        path.lineTo(50, 0);
        path.lineTo(50, 50);
        path.close();
        //x:100,y:50
        PathShape pathShape = new PathShape(path, 100, 100);
        mPathDrawable = new ShapeDrawable(pathShape);
        mPathDrawable.setBounds(new Rect(0, 0, 250, 150));
        mPathDrawable.getPaint().setColor(Color.GREEN);

        //在xml 中设置 PathShapeView 的宽和高分别是250px，150px shapeDrawable 占满整个view
//        PathShape pathShape = new PathShape(path,100,100);  讲 shapeDrawable 横向分为 100份，纵向 100份
//        path.lineTo(50, 0);   path在横向占 50份，
//        path.lineTo(50, 50);  path在纵向向占 50份，
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPathDrawable.draw(canvas);
    }
}
