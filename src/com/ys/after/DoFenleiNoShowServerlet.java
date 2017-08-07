package com.ys.after;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ys.biz.FenleiBiz;
import com.ys.common.Common;

public class DoFenleiNoShowServerlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取地址栏传递过来的数据就跟表单的GET请求处理时一样一样一样的
				String flId = request.getParameter("shenme");

				if(Common.isNotANumber(flId)){
					
						HttpServletResponse out =(HttpServletResponse) response.getWriter();
						
				} else {
					
					new FenleiBiz().buShowFenlei(Integer.parseInt(flId));
					
					response.sendRedirect("FenleiView.jsp");
				}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init() throws ServletException {
		
	}

	

}
