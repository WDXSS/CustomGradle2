package com.example.customview.view.constraint;
/**
 * {@link “参考地址  https://blog.csdn.net/u012551350/article/details/80204715”}
 */
public class ConstraintMain {


    // TODO 1.Circular positioning（圆形定位）
    /**
     * @{link ../../res/drawable/constraint01}
     *
     */
// <Button android:id="@+id/buttonA" ... />
//  <Button android:id="@+id/buttonB" ...
//    //引用的控件ID
//    app:layout_constraintCircle="@+id/buttonA"
//    //圆半径
//    app:layout_constraintCircleRadius="100dp"
//    //偏移圆角度  水平右方向为0逆时针方向旋转
//    app:layout_constraintCircleAngle="45" />


    //TODO 2.宽设置为 WRAP_CONTENT
    //效果 constraintwith.png
//    app:layout_constrainedWidth=”true|false” //默认false
//    app:layout_constrainedHeight=”true|false” //默认false


    //TODO 3.结合了以下两个属性来达到了需求的效果：
    //    app:layout_constraintHorizontal_chainStyle=”packed” //设置链样式
    //    app:layout_constraintHorizontal_bias=”0” // 设置水平偏好为0
    //效果 constraint03.png

//        <Button
//    android:id="@+id/bt_1"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:text="AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
//    app:layout_constrainedWidth="true" // 设置为true
//    app:layout_constraintHorizontal_bias="0" // 设置水平偏好为0
//    app:layout_constraintHorizontal_chainStyle="packed" //设置链样式
//    app:layout_constraintLeft_toLeftOf="parent"
//    app:layout_constraintRight_toLeftOf="@+id/bt_2"
//    app:layout_constraintTop_toTopOf="parent"/>
//
//    <Button
//    android:id="@+id/bt_2"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:text="BBBBBBBBBBB"
//    app:layout_constrainedWidth="true"
//    app:layout_constraintLeft_toRightOf="@+id/bt_1"
//    app:layout_constraintRight_toRightOf="parent"
//    app:layout_constraintTop_toTopOf="parent"/>

    //TODO 4. Chains（链）
    //效果：constraint04.png


    //TODO 5.goneMargin（隐藏边距）
//    layout_goneMarginStart
//    layout_goneMarginEnd
//    layout_goneMarginLeft
//    layout_goneMarginTop
//    layout_goneMarginRight
//    layout_goneMarginBottom

    //TODO 6.约束之百分比布局
    // 两种相同的效果 ---前提条件是至少需要将宽高中的一个设置为0dp
    // app:layout_constraintDimensionRatio="H,16:9"
    // app:layout_constraintDimensionRatio="W,9:16"
    //效果：constraint05.png

    //TODO 6.1 同时新增了app:layout_constraintHorizontal_bias="0"属性
    //效果：constraint06.png
//    我们可以改变偏好值，来调整位置偏向某一边。有点类似LinearLayout的weight属性。

    //TODO 6.2 最后需要调整控件距离顶部的高度为父控件高度的20%
    //效果：constraint07.png


    //TODO 7 Guideline
    /**
     * Guideline 与 LinearLayout 类似可以设置水平或垂直方向，
     * android:orientation="horizontal"，
     * android:orientation="vertical"，
     * 水平方向高度为0，垂直方向宽度为0
     */
//    layout_constraintGuide_begin 距离父容器起始位置的距离（左侧或顶部）
//    layout_constraintGuide_end 距离父容器结束位置的距离（右侧或底部）
//    layout_constraintGuide_percent 距离父容器宽度或高度的百分比

//<android.support.constraint.Guideline
//    android:layout_width="wrap_content"
//    android:orientation="vertical"
//    app:layout_constraintGuide_begin="100dp"
//    android:layout_height="wrap_content"/>
//    效果：constraint08.png

}
