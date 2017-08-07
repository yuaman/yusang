package com.ys.entity;

public class Yonghu extends BaseYonghu{

	public Yonghu() {
		super();
	}

	
	private String nicheng;
	private int xingbie;
	private String touxiang;
	private String aihao;
	private int quanxian;
	private int jifen;
	
	
	public Yonghu(String nicheng, int xingbie, String touxiang, String aihao, int quanxian, int jifen) {
		super();
		this.nicheng = nicheng;
		this.xingbie = xingbie;
		this.touxiang = touxiang;
		this.aihao = aihao;
		this.quanxian = quanxian;
		this.jifen = jifen;
	}
	
	
	public String getNicheng() {
		return nicheng;
	}
	public void setNicheng(String nicheng) {
		this.nicheng = nicheng;
	}
	public int getXingbie() {
		return xingbie;
	}
	public void setXingbie(int xingbie) {
		this.xingbie = xingbie;
	}
	public String getTouxiang() {
		return touxiang;
	}
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	public String getAihao() {
		return aihao;
	}
	public void setAihao(String aihao) {
		this.aihao = aihao;
	}
	public int getQuanxian() {
		return quanxian;
	}
	public void setQuanxian(int quanxian) {
		this.quanxian = quanxian;
	}
	public int getJifen() {
		return jifen;
	}
	public void setJifen(int jifen) {
		this.jifen = jifen;
	}
}
