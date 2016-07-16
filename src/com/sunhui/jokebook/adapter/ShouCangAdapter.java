package com.sunhui.jokebook.adapter;

import java.util.List;

import com.sunhui.jokebook.R;
import com.sunhui.jokebook.entity.Joke;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ShouCangAdapter extends BaseAdapter {
	private Context context;
	private List<Joke> shouCang;
	private LayoutInflater layoutInflater;
	private boolean show=false;
	private ListView listView;
	
	
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
			holder.ivDel=(ImageView) convertView.findViewById(R.id.ivDel);
			holder.joke=(TextView) convertView.findViewById(R.id.joke2);
			convertView.setTag(holder);
		}
		holder=(viewHolder) convertView.getTag();
		holder.joke.setText(joke.getContent());
		holder.ivDel.setTag("ivDel"+position);
		return convertView;
	}
	public void deleteToggle() {
		int maxPosition = getCount() - 1;
		if (show) { // Á¢¼´Òþ²Ø
			for (int i = 0; i <= maxPosition; i++) {
				final ImageView ivDel = (ImageView) listView
						.findViewWithTag("ivDel" + i);
				ObjectAnimator anim = ObjectAnimator.ofFloat(ivDel, "abc", 1f,
						0f);
				anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
					@Override
					public void onAnimationUpdate(ValueAnimator valueAnimator) {
						float val = (Float) valueAnimator.getAnimatedValue();
						ivDel.setScaleX(val);
						ivDel.setScaleY(val);
					}
				});
				anim.setDuration(500);
				anim.start();
			}
			show = false;
		} else { // Á¢¼´ÏÔÊ¾
			for (int i = 0; i <= maxPosition; i++) {
				final ImageView ivDel = (ImageView) listView
						.findViewWithTag("ivDel" + i);
				ObjectAnimator anim = ObjectAnimator.ofFloat(ivDel, "abc", 0f,
						1f);
				anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
					@Override
					public void onAnimationUpdate(ValueAnimator valueAnimator) {
						float val = (Float) valueAnimator.getAnimatedValue();
						ivDel.setScaleX(val);
						ivDel.setScaleY(val);
					}
				});
				anim.setDuration(500);
				anim.start();
			}
			show = true;
		}
	}
class viewHolder{
	TextView joke;
	ImageView ivDel;
}
}
