package com.ys.after;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ys.biz.FenleiBiz;
import com.ys.entity.Fenlei;

public class DoFenleiModifyServerlet extends HttpServlet{

	public DoFenleiModifyServerlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.字符编码
		request.setCharacterEncoding("UTF-8");
		//2.获取数据
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String fuid = request.getParameter("fuid");
		String miaoshu = request.getParameter("miaoshu");
		//封装数据
		Fenlei fenlei = new Fenlei();
		fenlei.setId(Integer.parseInt(id));
		fenlei.setTitle(title);
		fenlei.setFuFlId(Integer.parseInt(fuid));
		fenlei.setMiaoshu(miaoshu);
		
		new FenleiBiz().modifyFenlei(fenlei);

		//3.处理结果
		response.sendRedirect("initfenleiview");
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init() throws ServletException {
		
	}

}
