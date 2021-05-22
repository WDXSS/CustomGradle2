package com.example.book._7view.layoutmanager;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * CustomLayoutManager简介
 *  不考虑 ViewHolder 回收
 * @author ext.zhouchao3
 * @date 2021-05-17 11:13
 * <p>
 * 自定义 layoutManager
 * 1.onLayoutChildren 对 所有的 Item 进行布局
 * 1.1 将item 对应的View 添加进来
 * 1.2 对view 测量，摆放位置
 * 2.添加滑动效果
 * 2.1
 */
public class CustomLayoutManager extends RecyclerView.LayoutManager {
	private static final String TAG = "zhouc"+CustomLayoutManager.class.getSimpleName();
	public CustomLayoutManager() {
		//需要区分的几个方法
//		getChildAt() 获取某个可见位置的View， 可见的第一个item
//		getChildCount()  可见item 的个数
//		getItemCount()  adapter 中item 的总数
//		getPosition(view)  adapter 中 某个item 的索引

	}

	@Override
	public RecyclerView.LayoutParams generateDefaultLayoutParams() {
//		RecyclerView item 的 layoutParameters

		return new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT);
	}

	@Override
	public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
		super.onLayoutChildren(recycler, state);
		//所有 item 中的布局都是在 onLayoutChildren 中进行的
		//该函数主要做2件事
		//1.将所有的Item 对应的view 添加进来
		//2. 把所有的View 摆放在它应有的位置上

		//1.将所有的Item 对应的view 添加进来
		int offsetY = 0;//每个 item Y 上的偏移量
		for (int i = 0; i < getItemCount(); i++) {
			View view = recycler.getViewForPosition(i);
			addView(view);

			//2. 把所有的View 摆放在它应有的位置上
			//2.1 测量 view
			measureChildWithMargins(view, 0, 0);
			int height = getDecoratedMeasuredHeight(view);//获取item 测量高度，包含 itemDecorated
			int width = getDecoratedMeasuredWidth(view);
			//layoutDecorated 函数将每个item摆放在对应的位置
			layoutDecorated(view, 0, offsetY, width, offsetY + height);
			offsetY += height;
		}
		//所有 item 的总高度 如果所有 item 的总高度没有填满 RecycleView 的高度。则设置为RecycleView的高度
		mTotalHeight = Math.max(offsetY, getVerticalSpace());

	}

	// 添加滑动效果
	// 1.重写 canScrollVertically
	// 2.重写 scrollVerticallyBy()
	@Override
	public boolean canScrollVertically() {
		//纵向滑动
		return true;
	}

	private int mSumDy = 0;//滑动时，总的偏移量
	private int mTotalHeight = 0;// 所有 item 的总高度

	@Override
	public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
//		Log.d(TAG, "scrollVerticallyBy: dy = "+dy);
		//手指从下往上滑动（列表向下滚动），dy 是正值，手指从上往下滑动（列表向上滚动） dy 是负值
		//列表滚动到顶部或者底部，继续滑动屏幕，也会有dy 值，dy 是当次手指在屏幕上滑动的距离
		//dy 每次滑动的距离
//		offsetChildrenVertical(-dy);
		//1.判断 混动到顶部 和 底部
		//1.1 判断列表是否到顶相对比较容易，我们只需要把所有的dy相加，如果和小于0，就表示其已经到顶了。这时不让它再移动就行
		int travel = dy;//需要设置的偏移量
//		通过变量mSumDy 保存所有移动过的dy。如果当前移动的距离小于0，就不再累加dy，直接将它移动到y=0的位置，因为之前已经移动的距离是mSumdy。
		if (mSumDy + dy < 0) {
			//travel + mSumDy = 0  ==> travel -= mSumDy;
			travel -= mSumDy;
		} else if (mSumDy + dy > mTotalHeight - getVerticalSpace()) {
			//mSumDy+dy 表示当前的移动距离，mTotalHeight-getVerticalSpace（）表示当列表滑动到底时滑动的总距离
			// 2.判断列表是否到底的方法如下：我们需要知道所有item的总高度，用总高度减去最后一屏的高度，就是列表到底时的偏移值，如果大于这个偏移值就说明列表已经超过底部了
			// 2.1 在 onLayoutChildren 获取到 所有item 的高度之和

			//当列表滑动到底时，此次的移动距离要怎么计算呢？
			//将要移动的距离加上之前的总移动距离，应该是列表到底的距离。
//			mSumDy + travel = mTotalHeight - getVerticalSpace();
			// 需要的偏移量
			travel = mTotalHeight - getVerticalSpace() - mSumDy;
		}
		mSumDy += travel;
		//平移 容器中 item
		offsetChildrenVertical(-travel);


		return dy;
	}

	private int getVerticalSpace() {
		//getHeight() 屏的高度（RecycleView 的高度）？
		return getHeight() - getPaddingBottom() - getPaddingTop();
	}

	@Override
	public void detachAndScrapAttachedViews(@NonNull RecyclerView.Recycler recycler) {
		super.detachAndScrapAttachedViews(recycler);
		//仅用于onLayoutChildren中。在布局前，将所有正在显示的HolderView从RecyclerView中剥离，
		// 将其放在mAttachedScrap中，以供重新布局时使用
	}


}
