package com.ys.entity;

public class Biaoqian extends BaseBean{

	private int bq_id;
	private String title;
	private int  xianshi_flag;
	
	public int getBq_id() {
		return bq_id;
	}
	public void setBq_id(int bq_id) {
		this.bq_id = bq_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getXianshi_flag() {
		return xianshi_flag;
	}
	public void setXianshi_flag(int xianshi_flag) {
		this.xianshi_flag = xianshi_flag;
	}
	
}
