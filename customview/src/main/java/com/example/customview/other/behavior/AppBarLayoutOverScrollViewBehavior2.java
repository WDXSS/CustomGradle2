package com.example.customview.other.behavior;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import com.google.android.material.appbar.AppBarLayout;

/**
 * AppBarLayoutOverScrollViewBehavior2简介
 *  https://www.jianshu.com/p/bb3fe452e1f5?spm=a2c6h.12873639.0.0.6bc0307bEDmKG3
 * @author ext.zhouchao3
 * @date 2020-09-09 11:33
 */
public class AppBarLayoutOverScrollViewBehavior2 extends AppBarLayout.Behavior {
	private static final String TAG = "overScroll";
	private static final float TARGET_HEIGHT = 500; // 最大滑动距离
	private View mTargetView;  // 目标View  拉伸的图片
	private int mParentHeight;  // AppBarLayout的初始高度
	private int mTargetViewHeight; // 目标View的高度
	private float mTotalDy; // 总滑动的像素数
	private float mLastScale; //最终放大比例
	private int mLastBottom;  // AppBarLayout的最终Bottom值
	private boolean isAnimate;
	public AppBarLayoutOverScrollViewBehavior2() {
	}

	public AppBarLayoutOverScrollViewBehavior2(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/**
	 * AppBarLayout布局时调用
	 *
	 * @param parent 父布局CoordinatorLayout
	 * @param abl 使用此Behavior的AppBarLayout
	 * @param layoutDirection 布局方向
	 * @return 返回true表示子View重新布局，返回false表示请求默认布局
	 */
	@Override
	public boolean onLayoutChild(CoordinatorLayout parent, AppBarLayout abl, int layoutDirection) {
		boolean handled = super.onLayoutChild(parent, abl, layoutDirection);
		Log.d(TAG, "onLayoutChild: ");
		// 需要在调用过super.onLayoutChild()方法之后获取
		if (mTargetView == null) {
			mTargetView = parent.findViewWithTag(TAG);
			if (mTargetView != null) {
				initial(abl);
			}
		}
		return handled;
	}

	/**
	 * 当CoordinatorLayout的子View尝试发起嵌套滚动时调用
	 *
	 * @param parent 父布局CoordinatorLayout
	 * @param child 使用此Behavior的AppBarLayout
	 * @param directTargetChild CoordinatorLayout的子View，或者是包含嵌套滚动操作的目标View
	 * @param target 发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
	 * @param nestedScrollAxes 嵌套滚动的方向
	 * @param type the type of input which cause this scroll event
	 * @return 返回true表示接受滚动
	 */
	@Override
	public boolean onStartNestedScroll(CoordinatorLayout parent, AppBarLayout child, View directTargetChild, View target, int nestedScrollAxes, int type) {
		isAnimate = true;
		Log.d(TAG, "onStartNestedScroll: ");
		return super.onStartNestedScroll(parent, child, directTargetChild, target, nestedScrollAxes, type);
	}

	/**
	 * 当准备开始嵌套滚动时调用
	 *
	 * @param coordinatorLayout 父布局CoordinatorLayout
	 * @param child 使用此Behavior的AppBarLayout
	 * @param target 发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
	 * @param dx 用户在水平方向上滑动的像素数
	 * @param dy 用户在垂直方向上滑动的像素数
	 * @param consumed 输出参数，consumed[0]为水平方向应该消耗的距离，consumed[1]为垂直方向应该消耗的距离
	 */
	@Override
	public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dx, int dy, int[] consumed, int type) {
		Log.d(TAG, "onNestedPreScroll: ");
		//2.下滑处理
		//重写onNestedPreScroll()修改 AppBarLayout 滑动的顶部后的行为
		// 1.mTargetView不为null
		// 2.是向下滑动，dy<0表示向下滑动
		// 3.AppBarLayout已经完全展开，child.getBottom() >= mParentHeight
		// 三 . 上滑处理
		// 1.mTargetView不为null
		// 2.是向上滑动，dy>0表示向上滑动
		// 3.AppBarLayout尚未恢复到原始高度child.getBottom() > mParentHeight
		if (mTargetView != null && ((dy < 0 && child.getBottom() >= mParentHeight) || (dy > 0 && child.getBottom() > mParentHeight))) {
			scale(child, target, dy);
		} else {
			super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
		}
	}
	/**
	 * 当嵌套滚动的子View准备快速滚动时调用
	 *
	 * @param coordinatorLayout 父布局CoordinatorLayout
	 * @param child 使用此Behavior的AppBarLayout
	 * @param target 发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
	 * @param velocityX 水平方向的速度
	 * @param velocityY 垂直方向的速度
	 * @return 如果Behavior消耗了快速滚动返回true
	 */
	@Override
	public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, float velocityX, float velocityY) {
		Log.d(TAG, "onNestedPreFling: ");
		if (velocityY > 100) {
			Log.d(TAG, "onNestedPreFling: velocityY > 100" +(velocityY > 100));
			isAnimate = false;
		}
		return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
	}

	/**
	 * 当定制滚动时调用
	 *
	 * @param coordinatorLayout 父布局CoordinatorLayout
	 * @param abl 使用此Behavior的AppBarLayout
	 * @param target 发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
	 */
	@Override
	public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout abl, View target, int type) {
		Log.d(TAG, "onStopNestedScroll: ");
		recovery(abl);
		super.onStopNestedScroll(coordinatorLayout, abl, target, type);
	}

	/**
	 * 嵌套滚动时调用
	 *
	 * @param coordinatorLayout 父布局CoordinatorLayout
	 * @param child 使用此Behavior的AppBarLayout
	 * @param target 发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
	 * @param dxConsumed 由目标View滚动操作消耗的水平像素数
	 * @param dyConsumed 由目标View滚动操作消耗的垂直像素数
	 * @param dxUnconsumed 由用户请求但是目标View滚动操作未消耗的水平像素数
	 * @param dyUnconsumed 由用户请求但是目标View滚动操作未消耗的垂直像素数
	 */
	@Override
	public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
		super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed);
	}

	/**
	 * 当嵌套滚动已由CoordinatorLayout接受时调用
	 *
	 * @param coordinatorLayout 父布局CoordinatorLayout
	 * @param child 使用此Behavior的AppBarLayout
	 * @param directTargetChild CoordinatorLayout的子View，或者是包含嵌套滚动操作的目标View
	 * @param target 发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
	 * @param nestedScrollAxes 嵌套滚动的方向
	 */
	@Override
	public void onNestedScrollAccepted(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
		super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, axes, type);
	}
	/**
	 * 当嵌套滚动的子View快速滚动时调用
	 *
	 * @param coordinatorLayout 父布局CoordinatorLayout
	 * @param child 使用此Behavior的AppBarLayout
	 * @param target 发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
	 * @param velocityX 水平方向的速度
	 * @param velocityY 垂直方向的速度
	 * @param consumed 如果嵌套的子View消耗了快速滚动则为true
	 * @return 如果Behavior消耗了快速滚动返回true
	 */
	@Override
	public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout child, @NonNull View target, float velocityX, float velocityY, boolean consumed) {
		return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
	}

	private void initial(AppBarLayout abl) {
		Log.d(TAG, "initial: ");
		//// 必须设置ClipChildren为false，这样目标View在放大时才能超出布局的范围
		abl.setClipChildren(false);
		mParentHeight = abl.getHeight();
		mTargetViewHeight = mTargetView.getHeight();
	}

	private void scale(AppBarLayout abl, View target, int dy) {
		Log.d(TAG, "scale: ");
		// 累加垂直方向上滑动的像素数  //
		mTotalDy += -dy;
		// 不能大于最大滑动距离
		mTotalDy = Math.min(mTotalDy, TARGET_HEIGHT);
		mLastScale = Math.max(1f, 1f + mTotalDy / TARGET_HEIGHT);
		// 缩放目标View
		ViewCompat.setScaleX(mTargetView, mLastScale);
		ViewCompat.setScaleY(mTargetView, mLastScale);
		// 计算目标View放大后增加的高度
		mLastBottom = mParentHeight + (int) (mTargetViewHeight / 2 * (mLastScale - 1));
		// 修改AppBarLayout的高度
		abl.setBottom(mLastBottom);
		target.setScrollY(0);
	}

	private void recovery(final AppBarLayout abl) {
		Log.d(TAG, "recovery: ");
		if (mTotalDy > 0) {
			mTotalDy = 0;
			if (isAnimate) {
				// 使用属性动画还原
				ValueAnimator anim = ValueAnimator.ofFloat(mLastScale, 1f).setDuration(200);
				anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
					@Override
					public void onAnimationUpdate(ValueAnimator animation) {
						float value = (float) animation.getAnimatedValue();
						ViewCompat.setScaleX(mTargetView, value);
						ViewCompat.setScaleY(mTargetView, value);
						abl.setBottom((int) (mLastBottom - (mLastBottom - mParentHeight) * animation.getAnimatedFraction()));
					}
				});
				anim.start();
			} else {
				ViewCompat.setScaleX(mTargetView, 1f);
				ViewCompat.setScaleY(mTargetView, 1f);
				abl.setBottom(mParentHeight);
			}
		}
	}
}
