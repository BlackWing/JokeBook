package com.sunhui.jokebook.activity;

import java.util.List;

import com.sunhui.jokebook.R;
import com.sunhui.jokebook.adapter.MyAdapter;
import com.sunhui.jokebook.entity.Joke;
import com.sunhui.jokebook.presenter.Ipresenter;
import com.sunhui.jokebook.presenter.Presenter;
import com.sunhui.jokebook.view.IView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class JokeFragment extends Fragment implements IView, OnRefreshListener {
	private ListView lvJoke;
	private Ipresenter ipresenter;
	private List<Joke> result;
	private MyAdapter adapter;
	private SwipeRefreshLayout swipeRefreshLayout;
	private RecyclerView recyclerView;
	private List<Joke> shouCang;
	

	public JokeFragment() {
		super();
		ipresenter = new Presenter(this);
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 5:
				ipresenter.loadData();
				break;

			}

		}
	};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_joke, null);
		lvJoke = (ListView) view.findViewById(R.id.lvJoke);
		swipeRefreshLayout = (SwipeRefreshLayout) view
				.findViewById(R.id.sw_refresh);
		swipeRefreshLayout.setOnRefreshListener(this);
		swipeRefreshLayout.setColorScheme(android.R.color.holo_blue_bright,
				android.R.color.holo_red_dark, android.R.color.holo_green_dark,
				android.R.color.holo_orange_dark);
		ipresenter.loadData();
		setListener();
		return view;

	}

	private void setListener() {
		lvJoke.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				Joke joke=result.get(position);
				shouCang.add(joke);
			((FragnentActivity)getActivity()).setShouCang(shouCang);
			Toast.makeText(getActivity(), "收 藏 成 功 啦 ，小主！^_^", Toast.LENGTH_LONG).show();
				return false;
			}
		});
	}

	@Override
	public void setData(List<Joke> result) {
		this.result = result;
	}

	@Override
	public void showData() {
		adapter = new MyAdapter(getActivity(), result);
		lvJoke.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		swipeRefreshLayout.setRefreshing(false);
	}

	@Override
	public void onRefresh() {
		handler.sendEmptyMessageDelayed(5, 2000);

	}
	
	
}
