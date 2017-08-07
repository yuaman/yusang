package com.ys.after;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.ha.backend.Sender;

import com.ys.biz.YonghuBiz;
import com.ys.common.Common;
import com.ys.entity.Yonghu;

public class DoLoginForUserServerlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Common.CHARSET);
		
	    String ming = request.getParameter("username");
	    String mima = request.getParameter("userpwd");
	    
	    String callback = request.getParameter("callback");
	    if (Common.isEmpty(callback)) {
			response.sendRedirect("index");
		}
	   
	    Yonghu yonghu =new YonghuBiz().login(ming, mima);
	    
	    if (yonghu!=null) {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("yonghu", yonghu);
	    	response.sendRedirect(callback);
		}else{
			request.setAttribute("error", "用户名或密码错误");
			response.sendRedirect("loginForUser.jsp");
		}
	    
	    
	    
	    
	    
	}
         
}
