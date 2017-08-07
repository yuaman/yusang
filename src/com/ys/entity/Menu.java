package com.ys.entity;

public class Menu extends BaseBean{

	private String title;
	private String url;
	
	public Menu(int id, String title, String url) {
		super(id);
		this.title = title;
		this.url = url;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
