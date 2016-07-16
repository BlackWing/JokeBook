package com.sunhui.jokebook.activity;

import java.util.List;

import com.sunhui.jokebook.R;
import com.sunhui.jokebook.adapter.ShouCangAdapter;
import com.sunhui.jokebook.entity.Joke;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ListView;

public class MineFragment extends Fragment{
	private List<Joke> shouCang;
	private ListView lvMine;
	private ShouCangAdapter adapter;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
View view=inflater.inflate(R.layout.fragment_mine, null);
lvMine=(ListView) view.findViewById(R.id.lvJoke2);
((FragnentActivity)getActivity()).getShouCang();

adapter=new ShouCangAdapter(getActivity(), shouCang);
	lvMine.setAdapter(adapter);
return view;
}
}	
