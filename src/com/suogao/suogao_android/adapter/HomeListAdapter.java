package com.suogao.suogao_android.adapter;

import java.util.ArrayList;
import java.util.List;

import com.suogao.suogao_android.adapter.TimeTreeAdapter.ViewHolder;
import com.suogao.suogao_android.model.HomeItemModel;
import com.suogao.suogao_android.model.TimeTreeDataModel;
import com.suogao.suogao_android.model.TimeTreeItemModel;
import com.suogao.suogao_android.view.TimeTreeDataView;
import com.suogao.suogaoapp.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeListAdapter extends BaseAdapter {

	private List<HomeItemModel> list = new ArrayList<HomeItemModel>();
	private Context mContext;
	private LayoutInflater inflater;

	public HomeListAdapter(Context context) {
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
		HomeItemModel model = list.get(position);
		ViewHolder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_home, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.upData(model, position);
		return convertView;
	}

	public void refresh(List<HomeItemModel> listdata) {
		list.clear();
		list.addAll(listdata);
	}

	public class ViewHolder {
		public HomeItemModel data;
		private TextView title, text, type, state, name;
		private LinearLayout dataLayout;
		private int position;

		public ViewHolder(View view) {
			text = (TextView) view.findViewById(R.id.text);
			title = (TextView) view.findViewById(R.id.title);
			type = (TextView) view.findViewById(R.id.type);
			state = (TextView) view.findViewById(R.id.state);
			name = (TextView) view.findViewById(R.id.name);

		}

		public void upData(HomeItemModel model, int position) {
			data = model;
			this.position = position;
			title.setText(model.getTitle());
			text.setText("简介:" + model.getText());
			type.setText("类型：" + model.getType());
			state.setText(model.getState());
			name.setText("编剧：" + model.getAuthor());

		}
	}
}
