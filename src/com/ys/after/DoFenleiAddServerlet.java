package com.ys.after;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ys.biz.FenleiBiz;
import com.ys.entity.Fenlei;

public class DoFenleiAddServerlet extends HttpServlet{

	public DoFenleiAddServerlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String token = request.getParameter("tk");
		
        if(token!=null&&session.getAttribute("tk").equals(token)){
        	String title = request.getParameter("title");
    		String fuid = request.getParameter("fuid");
    		String miaoshu = request.getParameter("miaoshu");
    		
    		Fenlei fenlei = new Fenlei();
    		fenlei.setTitle(title);
    		fenlei.setFuFlId(Integer.parseInt(fuid));
    		fenlei.setMiaoshu(miaoshu);
    		
    		new FenleiBiz().addFenlei(fenlei);

    		response.sendRedirect("initfenleiview");
        }else{		
        response.sendRedirect("new404.jsp");
	}
	}
}
