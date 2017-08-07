package com.ys.after;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import com.ys.biz.GuanliyuanBiz;
import com.ys.entity.Guanliyuan;

import oracle.jdbc.util.Login;

public class DoLoginServerlet extends HttpServlet{

	public DoLoginServerlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置字符编码
		request.setCharacterEncoding("UTF-8");
		
		//2.获取表单数据，处理业务
		String dengluMing = request.getParameter("username");	//登录名
		String dengluMima = request.getParameter("userpwd"); 	//登陆密码
		
		Guanliyuan guanliyuan = new GuanliyuanBiz().findByMingHeMima(dengluMing, dengluMima);
			
		//3.显示处理结果
		if(guanliyuan != null){
			
			//out.print(guanliyuan.getMingzi() + ",你好!");
			//想传递到目标页面的数据存储起来setAttribute(字符串,Object)
			HttpSession session = request.getSession();
			session.setAttribute("adminName", guanliyuan.getMingzi());
			
			//JSP中通过代码进行页面跳转
			//request的做法1.获取转发器
			RequestDispatcher dispatcher = request.getRequestDispatcher("AdminIndex.jsp");
			dispatcher.forward(request, response);
			
		} else {
			
			//response 重定向 只有在不传递任何数据的时候才调用 
					//response.sendRedirect("login.jsp");
					request.setAttribute("error", "用户名或密码不正确");
					
					request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init() throws ServletException {
		
	}

}
