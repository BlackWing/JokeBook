package com.sunhui.jokebook.entity;

public class Joke {
	private String content;
	private String hashId;
	private String unixtime;

	public Joke(String content, String hashId, String unixtime) {
		super();
		this.content = content;
		this.hashId = hashId;
		this.unixtime = unixtime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHashId() {
		return hashId;
	}

	public void setHashId(String hashId) {
		this.hashId = hashId;
	}

	public String getUnixtime() {
		return unixtime;
	}

	public void setUnixtime(String unixtime) {
		this.unixtime = unixtime;
	}

}
