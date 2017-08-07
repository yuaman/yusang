package com.ys.entity;

public class Fenlei extends BaseBean{

	
	
	private String title;
	private int fuFlId;
	private int xianshiFlag;
	private String miaoshu;
	
		
	public Fenlei() {
		super();
	}
	
	public Fenlei(int id,String title, int fuFlId, int xianshiFlag, String miaoshu) {
		super(id);
		this.title = title;
		this.fuFlId = fuFlId;
		this.xianshiFlag = xianshiFlag;
		this.miaoshu = miaoshu;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getFuFlId() {
		return fuFlId;
	}
	public void setFuFlId(int fuFlId) {
		this.fuFlId = fuFlId;
	}
	public int getXianshiFlag() {
		return xianshiFlag;
	}
	public void setXianshiFlag(int xianshiFlag) {
		this.xianshiFlag = xianshiFlag;
	}
	public String getMiaoshu() {
		return miaoshu;
	}
	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}
	
	

}
