package com.sunhui.jokebook.presenter;

import java.util.ArrayList;
import java.util.List;

import com.sunhui.jokebook.entity.Joke;
import com.sunhui.jokebook.model.Imodel;
import com.sunhui.jokebook.model.ImodelCallback;
import com.sunhui.jokebook.model.Model;
import com.sunhui.jokebook.view.IView;

public class Presenter implements Ipresenter {
	private IView view;
	private Imodel model;

	public Presenter(IView view) {
		this.view = view;
		model = new Model();
	}

	@Override
	public void loadData() {
		model.getData(new ImodelCallback() {
			@Override
			public void findData(Object object) {
				List<Joke> result = (List<Joke>) object;
				view.setData(result);
				view.showData();
			}
		});
	}

}
