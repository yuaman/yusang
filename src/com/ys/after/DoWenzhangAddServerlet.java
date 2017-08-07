package com.ys.after;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ys.biz.WenzhangBiz;
import com.ys.entity.Wenzhang;

public class DoWenzhangAddServerlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
     
		String title = request.getParameter("title");
		String fl_id = request.getParameter("fenlei");	
		String zaiyao = request.getParameter("zaiyao");
		String zuozhe = request.getParameter("zuozhe");
		String suoluetu = request.getParameter("suoluetu");
		String biaoqian = request.getParameter("biaoqian");
		String neirong = request.getParameter("neirong");
		
		Wenzhang wenzhang =  new Wenzhang();		
		wenzhang.setTitle(title);
		wenzhang.setFenlei(Integer.parseInt(fl_id));
		wenzhang.setZuozhe(zuozhe);
		wenzhang.setSuoluetu(suoluetu);
		wenzhang.setZaiyao(zaiyao);
		wenzhang.setBiaoqian(biaoqian);
		wenzhang.setNeirong((neirong));
	
		
		
		
		new WenzhangBiz().addWenzhang(wenzhang);
		
		
		response.sendRedirect("WenzhangView.jsp");
	}

}
