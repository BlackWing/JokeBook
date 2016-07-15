package com.sunhui.jokebook.activity;

import com.sunhui.jokebook.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MineFragment extends Fragment{
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
View view=inflater.inflate(R.layout.fragment_mine, null);
	return view;
}
}	
