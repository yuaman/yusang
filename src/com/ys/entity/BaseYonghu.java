package com.ys.entity;

/**
 * �û��Ļ���
 *
 * <pre>
 * 	@author Administrator�ظ�2016�����������
 *
 *  ����ʱ��: 2016��5��10������9:04:15
 *
 *  ��Ȩ��Ϣ:�ܘ�����
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
