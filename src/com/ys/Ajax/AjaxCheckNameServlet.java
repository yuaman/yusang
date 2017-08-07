package com.ys.Ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ys.biz.YonghuBiz;
import com.ys.common.Common;

public class AjaxCheckNameServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Common.CHARSET);
		
		String dengluming = request.getParameter("username");
		
		PrintWriter out = response.getWriter();
		if (new YonghuBiz().checkUname(dengluming)) {
			out.print("a");
		}else{
			out.print("b");
		}
		out.flush();
		out.close();
		
	}

}
