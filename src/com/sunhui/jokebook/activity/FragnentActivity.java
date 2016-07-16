package com.sunhui.jokebook.activity;

import java.util.ArrayList;
import java.util.List;

import com.sunhui.jokebook.R;
import com.sunhui.jokebook.R.layout;
import com.sunhui.jokebook.R.menu;
import com.sunhui.jokebook.adapter.mineAdapter;
import com.sunhui.jokebook.entity.Joke;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FragnentActivity extends FragmentActivity {
	private ViewPager viewPager;
	private RadioGroup radioGroup;
	private RadioButton rbJoke;
	private RadioButton rbMine;
	private ArrayList<Fragment> fragments;
	private mineAdapter pagerAdapter;
	private List<Joke> shouCang;

	public List<Joke> getShouCang() {
		return shouCang;
	}

	public void setShouCang(List<Joke> shouCang) {
		this.shouCang = shouCang;
	}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragnent);
		setViews();
		setListenner();
		setAdapter();

	}

	private void setAdapter() {
		fragments=new ArrayList<Fragment>();
		fragments.add(new JokeFragment());
		fragments.add(new MineFragment());
		pagerAdapter=new mineAdapter(getSupportFragmentManager(), fragments);
		viewPager.setAdapter(pagerAdapter);
		
	}

	private void setListenner() {
		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int i) {
				switch (i) {
				case R.id.joke:
					viewPager.setCurrentItem(0);
					break;
				case R.id.mine:
					viewPager.setCurrentItem(1);
					break;
				}
			}
		});
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int i) {
				switch (i) {
				case 0:
					rbJoke.setChecked(true);
					break;
				case 1:
					rbMine.setChecked(true);
					break;
				}
				
			}
			
			@Override
			public void onPageScrolled(int i, float v, int i2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int i) {
				
			}
		});
	}

	private void setViews() {
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
		rbJoke = (RadioButton) findViewById(R.id.joke);
		rbMine = (RadioButton) findViewById(R.id.mine);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fragnent, menu);
		return true;
	}

}
