package com.sunhui.jokebook.utils;

import java.util.List;

import com.sunhui.jokebook.entity.Joke;

public class QuerResult {
	private String reason;
	private List<Joke> result;
	private int error_code;
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public List<Joke> getResult() {
		return result;
	}
	public void setResult(List<Joke> result) {
		this.result = result;
	}
	public int getError_code() {
		return error_code;
	}
	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

}
