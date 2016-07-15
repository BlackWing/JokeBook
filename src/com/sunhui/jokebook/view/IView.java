package com.sunhui.jokebook.view;

import java.util.List;

import com.sunhui.jokebook.entity.Joke;

public interface IView {
	void setData(List<Joke> result);
	void showData();
}
