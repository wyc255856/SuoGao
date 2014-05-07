package com.suogao.suogao_android.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.suogao.suogao_android.model.HomeItemModel;
import com.suogao.suogao_android.model.TabMenuItemModel;
import com.suogao.suogaoapp.R;

public class MenuAdapter extends BaseAdapter {

	private List<TabMenuItemModel> list = new ArrayList<TabMenuItemModel>();
	private Context mContext;
	private LayoutInflater inflater;

	public MenuAdapter(Context context) {
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
		TabMenuItemModel model = list.get(position);
		ViewHolder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_menu, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.upData(model, position);
		return convertView;
	}

	public void refresh(List<TabMenuItemModel> listdata) {
		list.clear();
		list.addAll(listdata);
	}

	public class ViewHolder {
		public TabMenuItemModel data;
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

		public void upData(TabMenuItemModel model, int position) {
			data = model;
			this.position = position;
			title.setText(model.getTitle());

		}
	}
}
