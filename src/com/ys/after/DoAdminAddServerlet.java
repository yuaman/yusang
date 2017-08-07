package com.ys.after;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ys.biz.AdminBiz;
import com.ys.entity.Admin;

public class DoAdminAddServerlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		
		String DENGLUMING = request .getParameter("dengluming");
		String DENGLUMIMA = request.getParameter("denglumima");
		String QUANXIAN  = request.getParameter("quanxian");
		String MINGZI = request.getParameter("mingzi");
		
		Admin admin = new Admin();
		
		admin.setDENGLUMING(DENGLUMING);
		admin.setDENGLUMIMA(DENGLUMIMA);
		admin.setQUANXIAN(Integer.parseInt(QUANXIAN));
		admin.setMINGZI(MINGZI);
		
		new AdminBiz().addAdmin(admin);
		
		response.sendRedirect("initAdminView");
		
	}

}
