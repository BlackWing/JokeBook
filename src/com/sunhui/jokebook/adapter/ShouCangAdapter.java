package com.sunhui.jokebook.adapter;

import java.util.List;

import com.sunhui.jokebook.R;
import com.sunhui.jokebook.entity.Joke;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ShouCangAdapter extends BaseAdapter {
	private Context context;
	private List<Joke> shouCang;
	private LayoutInflater layoutInflater;
	
	
	public ShouCangAdapter(Context context, List<Joke> shouCang) {
		super();
		this.context = context;
		this.shouCang = shouCang;
		this.layoutInflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		
		return shouCang.size();
	}

	@Override
	public Joke getItem(int position) {
		return shouCang.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Joke joke=getItem(position);
		viewHolder holder;
		if (convertView==null) {
			holder=new viewHolder();
			convertView=layoutInflater.inflate(R.layout.mine_item, null);
			
			holder.joke=(TextView) convertView.findViewById(R.id.joke2);
			convertView.setTag(holder);
		}
		holder=(viewHolder) convertView.getTag();
		holder.joke.setText(joke.getContent());
		return convertView;
	}
class viewHolder{
	TextView joke;
	
}
}
