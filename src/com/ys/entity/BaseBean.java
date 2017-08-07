package com.ys.entity;

/**
 * 
 * 所有实体基类
 *
 * <pre>
 * 	@author Administrator霖哥2016夏于中软国际
 *
 *  创建时间: 2016年5月10日上午9:06:17
 *
 *  版权信息:榆槡导读
 * </pre>
 */
public class BaseBean {

	private int id;

	public BaseBean() {
	}

	public BaseBean(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
