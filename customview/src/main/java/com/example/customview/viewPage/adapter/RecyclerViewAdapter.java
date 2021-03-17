package com.example.customview.viewPage.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.customview.R;
import com.example.customview.viewPage.helper.CardAdapterHelper;

import java.util.List;

/**
 * RecyclerView的适配器
 * Created by CodingEnding on 2018/3/30.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
	private List<String> dataList;//数据源
	private LayoutInflater inflater;//布局解析器
	private ItemClickListener itemClickListener;//列表项点击监听器
	private Context mContext;

	//关键点 ： 对View 进行修改
	private CardAdapterHelper mCardAdapterHelper = new CardAdapterHelper();

	public RecyclerViewAdapter(Context context, List<String> dataList) {
		this.dataList = dataList;
		this.mContext = context;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		if (inflater == null) {//避免多次初始化
			inflater = LayoutInflater.from(parent.getContext());
		}
		View itemView = inflater.inflate(R.layout.detail_base_hot_line_view_page_layout, parent, false);
		ViewHolder viewHolder = new ViewHolder(itemView);
		mCardAdapterHelper.onCreateViewHolder(parent, viewHolder.itemView);


		return viewHolder;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		mCardAdapterHelper.onBindViewHolder(holder.itemView, position, getItemCount());

		final String itemContent = dataList.get(position);
//		Glide.with(mContext).load(dataList.get(position)).into(holder.mImageView);

		//为列表项设置点击监听
		if (itemClickListener != null) {
			holder.itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					itemClickListener.onItemClick(itemContent);
				}
			});
			holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View v) {
					itemClickListener.onItemLongClick(itemContent);
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
