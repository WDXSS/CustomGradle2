package com.example.customview.view.constraint;

import com.example.jetpack.DevDescribe;

/**
 * https://blog.csdn.net/u012551350/article/details/80204715
 */
@DevDescribe("ConstraintMain 的继续")
public class ConstraintMain2 {

    //TODO 8. Barrier
    //可以使用属性constraint_referenced_ids属性来引用多个带约束的组件，从而将它们看作一个整体
    /**
     * 姓名，联系方式位于 A 区域（随着文本的宽度变化 A 区域的宽度也随之变化），B 区域在 A 区域的右侧
     */
    //效果：contraint09  contraint09.xml
    /**
     * TODO barrierDirection 指定方向，constraint_referenced_ids引用的控件 id（多个id以逗号隔开）
     * <androidx.constraintlayout.widget.Barrier
     *         android:id="@+id/barrier"
     *         android:layout_width="wrap_content"
     *         android:layout_height="wrap_content"
     *         app:barrierDirection="right"
     *         app:constraint_referenced_ids="tv_name,tv_contract"/>
     */
}
