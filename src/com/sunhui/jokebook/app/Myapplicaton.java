package com.sunhui.jokebook.app;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;
import android.content.Context;

public class Myapplicaton extends Application {
	public static final String TextURL = "http://v.juhe.cn/joke/randJoke.php?"
			+ "type=&key=2267b35b3ae0aaf4513aeb8081f74b61";
	private static Myapplicaton context;
	private static RequestQueue queue;
	@Override
	public void onCreate() {
		super.onCreate();
		context=this;
		queue=Volley.newRequestQueue(this);
	}
	public static Myapplicaton getContext() {
		return context;
	}
	
	public static RequestQueue getQueue() {
		return queue;
	}
	
}
