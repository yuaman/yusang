package com.ys.entity;

/**
 * ����Աʵ����
 *
 *
 * <pre>
 * 	@author ��ΰ��
 *
 *  ����ʱ��: 2016��5��10������9:07:08
 *
 *  ��Ȩ��Ϣ:�ܘ�����
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
