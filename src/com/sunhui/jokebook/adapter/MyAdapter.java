package com.sunhui.jokebook.adapter;

import java.util.List;

import com.sunhui.jokebook.R;
import com.sunhui.jokebook.entity.Joke;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	private Context context;
	private List<Joke> result;
	private LayoutInflater layoutInflater;

	public MyAdapter(Context context, List<Joke> result) {
		super();
		this.context = context;
		this.result = result;
		this.layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return result.size();
	}

	@Override
	public Joke getItem(int i) {
		return result.get(i);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Joke joke = getItem(position);
		viewHoider holder;
		if (convertView == null) {
			holder = new viewHoider();
			convertView = layoutInflater.inflate(R.layout.joke_item, null);
			holder.joke = (TextView) convertView.findViewById(R.id.joke);

			convertView.setTag(holder);
		}
		holder = (viewHoider) convertView.getTag();
		holder.joke.setText(joke.getContent());
		
		return convertView;
	}

	class viewHoider {
		TextView joke;
		
	}

}
