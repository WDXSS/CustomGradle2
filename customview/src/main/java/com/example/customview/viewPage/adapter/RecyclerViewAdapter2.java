package com.example.customview.viewPage.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.customview.R;
import com.example.customview.viewPage.helper.CardAdapterHelper;

import java.util.List;

/**
 * RecyclerView的适配器
 * Created by CodingEnding on 2018/3/30.
 */
public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder> {
	private List<Integer> dataList;//数据源
	private LayoutInflater inflater;//布局解析器
	private ItemClickListener itemClickListener;//列表项点击监听器
	private Context mContext;

	private CardAdapterHelper mCardAdapterHelper = new CardAdapterHelper();

	public RecyclerViewAdapter2(Context context, List<Integer> dataList) {
		this.dataList = dataList;
		this.mContext = context;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		if (inflater == null) {//避免多次初始化
			inflater = LayoutInflater.from(parent.getContext());
		}
		View itemView = inflater.inflate(R.layout.recycler_view_item, parent, false);
		mCardAdapterHelper.onCreateViewHolder(parent, itemView);
		return new ViewHolder(itemView);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		mCardAdapterHelper.onBindViewHolder(holder.itemView, position, getItemCount());
		final Integer itemContent = dataList.get(position);
		holder.mImageView.setImageResource(dataList.get(position));
//		Glide.with(mContext).load(dataList.get(position)).into(holder.mImageView);

		//为列表项设置点击监听
		if (itemClickListener != null) {
			holder.itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					itemClickListener.onItemClick(position + "");
				}
			});
			holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View v) {
					itemClickListener.onItemLongClick(position + "");
					return true;
				}
			});
		}
	}

	@Override
	public int getItemCount() {
		return dataList.size();
	}

	//为RecyclerView设置点击监听器
	public void setItemClickListener(ItemClickListener itemClickListener) {
		this.itemClickListener = itemClickListener;
	}

	//自定义ViewHolder
	static class ViewHolder extends RecyclerView.ViewHolder {
		private ImageView mImageView;

		public ViewHolder(View itemView) {
			super(itemView);
			mImageView = itemView.findViewById(R.id.img);
		}
	}

	//自定义的点击监听器接口
	public interface ItemClickListener {
		void onItemClick(String clickItem);//单击事件

		void onItemLongClick(String clickItem);//长按事件
	}
}
