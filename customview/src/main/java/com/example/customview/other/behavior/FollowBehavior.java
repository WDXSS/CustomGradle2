package com.example.customview.other.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.jetpack.DevDescribe;

import org.jetbrains.annotations.NotNull;

@DevDescribe("自定义 CoordinatorLayout 的 Behavior， 泛型为 影子 View ( 要跟着别人动的那个 )")
public class FollowBehavior extends CoordinatorLayout.Behavior<TextView> {
    private static final String TAG = "FollowBehavior";
    
    public FollowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 判断child的布局是否依赖 dependency
     * <p>
     * 根据逻辑来判断返回值，返回 false 表示不依赖，返回 true 表示依赖
     * <p>
     * 在一个交互行为中，Dependent View 的变化决定了另一个相关 View 的行为。
     * 在这个例子中， Button 就是 Dependent View，因为 TextView 跟随着它。
     * 实际上 Dependent View 就相当于我们前面介绍的被观察者
     */
    @Override
    public boolean layoutDependsOn(@NotNull CoordinatorLayout parent, @NotNull TextView child, @NotNull View dependency) {
        Log.d(TAG, "layoutDependsOn()  = [" + parent.getTag() + "], child = [" + child.getTag() + "], dependency = [" + dependency.getTag() + "]");
        return dependency instanceof Button;
    }

    @Override
    public boolean onDependentViewChanged(@NotNull CoordinatorLayout parent, TextView child, View dependency) {
        child.setX(dependency.getX());
        child.setY(dependency.getY() + 100);
        return true;
    }
}
