package com.ys.entity;

/**
 * 管理员实体类
 *
 *
 * <pre>
 * 	@author 于伟光
 *
 *  创建时间: 2016年5月10日上午9:07:08
 *
 *  版权信息:榆槡导读
 * </pre>
 */
public class Guanliyuan extends BaseYonghu {

	private int quanxian;
	private String mingzi;
	
	public Guanliyuan() {
		super();
	}
	public Guanliyuan(int id, String dengluMing, String dengluMima, int quanxian, String mingzi) {
		super(id, dengluMing, dengluMima);
		this.quanxian = quanxian;
		this.mingzi = mingzi;
	}
	public int getQuanxian() {
		return quanxian;
	}
	public void setQuanxian(int quanxian) {
		this.quanxian = quanxian;
	}
	public String getMingzi() {
		return mingzi;
	}
	public void setMingzi(String mingzi) {
		this.mingzi = mingzi;
	}
	
	
}
