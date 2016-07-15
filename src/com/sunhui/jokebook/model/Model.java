package com.sunhui.jokebook.model;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.sunhui.jokebook.app.Myapplicaton;
import com.sunhui.jokebook.entity.Joke;
import com.sunhui.jokebook.utils.QuerResult;

public class Model implements Imodel {
	private RequestQueue queue;
	public Model() {

		queue = Volley.newRequestQueue(Myapplicaton.getContext());
	}

	@Override
	public void getData(final ImodelCallback callback) {
		StringRequest request = new StringRequest(Myapplicaton.TextURL,
				new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						List<Joke> result = new ArrayList<Joke>();
						Gson gson = new Gson();
						QuerResult quer = gson.fromJson(response,
								QuerResult.class);
						result = quer.getResult();
						callback.findData(result);
//						Log.i("haha", result.get(0).getContent());
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {

					}
				});
		queue.add(request);
	}

		
		
}
