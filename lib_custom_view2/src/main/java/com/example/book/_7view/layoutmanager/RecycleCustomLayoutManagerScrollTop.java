package com.jd.app.reader.bookstore.coupon;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jd.app.reader.bookstore.sort.BSThirdSortContract;

/**
 * RecycleCustomLayoutManagerScrollTop ViewHolder 回收
 * 完成 了向上滚动
 *
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
public class RecycleCustomLayoutManagerScrollTop extends RecyclerView.LayoutManager {
	private int mItemWidth;
	private int mItemHeight;
	private SparseArray<Rect> mRectSparseArray = new SparseArray<>();

	public RecycleCustomLayoutManagerScrollTop() {
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
		if (getItemCount() == 0) {
			//没有 item
			detachAndScrapAttachedViews(recycler);//将所有的可见HolderView剥离
		}

		detachAndScrapAttachedViews(recycler);
		View view = recycler.getViewForPosition(0);
		measureChildWithMargins(view, 0, 0);
		mItemWidth = getDecoratedMeasuredWidth(view);
		mItemHeight = getDecoratedMeasuredHeight(view);
		int visibleCount = getVerticalSpace() / mItemHeight;//显示的行数

		//定义 y 上的偏移量
		int offsetY = 0;
		//由于每个item的大小都是固定的，因此，为了布局方便，我们利用一个变量来保存初始化时Adapter中每一个item的位置
		for (int i = 0; i < getItemCount(); i++) {
			Rect rect = new Rect(0, offsetY, mItemWidth, offsetY + mItemHeight);
			offsetY += mItemHeight;
			mRectSparseArray.put(i, rect);
		}
		for (int i = 0; i < visibleCount; i++) {
			Rect rect = mRectSparseArray.get(i);
			View childView = recycler.getViewForPosition(i);
			addView(childView);
			//addView 以后先测量，后布局
			measureChildWithMargins(childView, 0, 0);
			layoutDecoratedWithMargins(childView, rect.left, rect.top, rect.right, rect.bottom);
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

		int travel = dy;//需要设置的偏移量
//		通过变量mSumDy 保存所有移动过的dy。如果当前移动的距离小于0，就不再累加dy，直接将它移动到y=0的位置，因为之前已经移动的距离是mSumdy。
		if (mSumDy + dy < 0) {
			//travel + mSumDy = 0  ==> travel -= mSumDy;
			travel -= mSumDy;
		} else if (mSumDy + dy > mTotalHeight - getVerticalSpace()) {
			travel = mTotalHeight - getVerticalSpace() - mSumDy;
		}
		//判断回收的item
		//1。顶部越界（向下滑动）
		for (int i = getChildCount() - 1; i >= 0; i--) {
			View childView = getChildAt(i);//获取当前显示在item ，从底部开始
			//回收当前屏幕，顶部越界
			if (travel > 0) {
				if (getBottomDecorationHeight(childView) - travel < 0) {
					removeAndRecycleView(childView, recycler);
					continue;
				}
			}
		}

		Rect visibleRect = getVisibleArea(travel);
		//布局子view
		if (travel >= 0) {
			View lastView = getChildAt(getChildCount() - 1);
			int minPos = getPosition(lastView) + 1;// 从最后一个view + 1 开始计算
			//空白区域 顺序添加item  循环的是整个的 adapter 的 item
			for (int i = minPos; i <= getItemCount() - 1; i++) {
				Rect rect = mRectSparseArray.get(i);
				if (visibleRect.contains(rect)) {
					//显示的区域，包含向下找到的item
					View childView = recycler.getViewForPosition(i);
					addView(childView);//添加 view
					measureChildWithMargins(childView, 0, 0);//测量 view
					//top = rect.top-mSumDy; top 是到屏幕 顶部的距离（0，0）; Rect.top 包含了超出屏幕顶部的距离，所以要减去移动距离
					layoutDecoratedWithMargins(childView, rect.left, rect.top-mSumDy,rect.right,rect.bottom -mSumDy);
				}else{
					break;
				}
			}
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

	private Rect getVisibleArea(int travel) {
		//移动后 当前屏幕的位置
		int left = getPaddingLeft();
		int top = getPaddingTop() + mSumDy + travel;
		int right = mItemWidth + getPaddingLeft();
		int bottom = mSumDy + travel + getVerticalSpace();
		Rect result = new Rect(left, top, right, bottom);
		return result;
	}
}
