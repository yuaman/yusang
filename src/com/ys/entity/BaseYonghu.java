package com.ys.entity;

/**
 * 用户的基类
 *
 * <pre>
 * 	@author Administrator霖哥2016夏于中软国际
 *
 *  创建时间: 2016年5月10日上午9:04:15
 *
 *  版权信息:榆槡导读
 * </pre>
 */
public class BaseYonghu extends BaseBean {
	
	private String dengluMing;
	private String dengluMima;
	
	public BaseYonghu() {
		super();
	}
	public BaseYonghu(int id, String dengluMing, String dengluMima) {
		super(id);
		this.dengluMing = dengluMing;
		this.dengluMima = dengluMima;
	}
	public String getDengluMing() {
		return dengluMing;
	}
	public void setDengluMing(String dengluMing) {
		this.dengluMing = dengluMing;
	}
	public String getDengluMima() {
		return dengluMima;
	}
	public void setDengluMima(String dengluMima) {
		this.dengluMima = dengluMima;
	}
	
	

}
