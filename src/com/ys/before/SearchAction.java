package com.ys.before;

import java.util.List;

import org.apache.commons.lang3.Validate;

import com.opensymphony.xwork2.ActionSupport;
import com.ys.biz.WenzhangBiz;
import com.ys.entity.Wenzhang;

public class SearchAction extends ActionSupport{
	private String keyword;
	
           public String getKeyword() {
		return keyword;
	}

	/*public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

		List<Wenzhang> list;
		
//		public String execute(){
//			List<Wenzhang> list = new WenzhangBiz().findByTitle(keyword);
//			
//			
*///		}
 }
