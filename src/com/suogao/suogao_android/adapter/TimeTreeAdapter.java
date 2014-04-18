package com.suogao.suogao_android.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.suogao.suogao_android.model.TimeTreeDataModel;
import com.suogao.suogao_android.model.TimeTreeItemModel;
import com.suogao.suogao_android.view.TimeTreeDataView;
import com.suogao.suogaoapp.R;

public class TimeTreeAdapter extends BaseAdapter {
	private List<TimeTreeItemModel> list = new ArrayList<TimeTreeItemModel>();
	private Context mContext;
	private LayoutInflater inflater;

	public TimeTreeAdapter(Context context) {
		mContext = context;
		inflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TimeTreeItemModel model = list.get(position);
		ViewHolder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_time_tree, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.upData(model, position);
		return convertView;
	}

	public void refresh(List<TimeTreeItemModel> listdata) {
		list.clear();
		list.addAll(listdata);
	}

	public class ViewHolder {
		public TimeTreeItemModel data;
		private TextView date, title;
		private LinearLayout dataLayout;
		private View top, end;
		private int position;

		public ViewHolder(View view) {
			date = (TextView) view.findViewById(R.id.date);
			title = (TextView) view.findViewById(R.id.title);
			top = view.findViewById(R.id.top_line);
			end = view.findViewById(R.id.end_line);
			dataLayout = (LinearLayout) view.findViewById(R.id.data_layout);
			view.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (!data.isOpen()) {
						dataLayout.setVisibility(View.GONE);
					} else {
						dataLayout.setVisibility(View.VISIBLE);
					}
					data.setOpen(!data.isOpen());
					if (position == getCount() - 1) {
						if (data.isOpen()) {
							end.setBackgroundColor(0x00000000);
						} else {
							end.setBackgroundColor(mContext.getResources()
									.getColor(R.color.time_tree_line));
						}
					} else {
						end.setBackgroundColor(mContext.getResources()
								.getColor(R.color.time_tree_line));
					}

				}
			});
		}

		public void upData(TimeTreeItemModel model, int position) {
			data = model;
			this.position = position;
			if (position == 0) {
				top.setBackgroundColor(0x00000000);
			} else {
				top.setBackgroundColor(mContext.getResources().getColor(
						R.color.time_tree_line));
			}
			if (position == getCount() - 1) {
				if (data.isOpen()) {
					end.setBackgroundColor(0x00000000);
				} else {
					end.setBackgroundColor(mContext.getResources().getColor(
							R.color.time_tree_line));
				}
			} else {
				end.setBackgroundColor(mContext.getResources().getColor(
						R.color.time_tree_line));
			}

			date.setText(data.getDate());
			title.setText(data.getTitle());
			dataLayout.removeAllViews();
			List<TimeTreeDataModel> datalist = data.getDataList();
			for (int i = 0; i < datalist.size(); i++) {
				TimeTreeDataView timeView = new TimeTreeDataView(mContext);
				timeView.setData(datalist.get(i), i + 1);
				dataLayout.addView(timeView);
			}
		}

	}

}
