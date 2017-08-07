package com.ys.entity;

import javax.management.loading.PrivateClassLoader;

public class Comment extends BaseBean{
	private String neirong;
    private Yonghu yonghu;
    private Wenzhang wenzhang;
    private String shijian;
    private int zan;
	
       public String getNeirong() {
		return neirong;
	}
	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}
	public Yonghu getYonghu() {
		return yonghu;
	}
	public void setYonghu(Yonghu yonghu) {
		this.yonghu = yonghu;
	}
	public Wenzhang getWenzhang() {
		return wenzhang;
	}
	public void setWenzhang(Wenzhang wenzhang) {
		this.wenzhang = wenzhang;
	}
	public String getShijian() {
		return shijian;
	}
	public void setShijian(String shijian) {
		this.shijian = shijian;
	}
	public int getZan() {
		return zan;
	}
	public void setZan(int zan) {
		this.zan = zan;
	}
	
}
