package com.ys.before;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ys.biz.CommentBiz;
import com.ys.biz.WenzhangBiz;
import com.ys.common.Common;
import com.ys.entity.Comment;
import com.ys.entity.Wenzhang;



public class InitArticleDetailsServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		
		
		if (Common.isNotANumber(id)) {
			response.sendRedirect("new404.jsp");
		}
		
		//ҵ����
		WenzhangBiz wenzhangBiz = new WenzhangBiz();
		CommentBiz commentBiz = new CommentBiz();
		
		//ȡ������
		Wenzhang wenzhang = wenzhangBiz.findById((Integer.parseInt(id)));
		
		//ȡ����������
		List<Comment> hots = commentBiz.findHot((Integer.parseInt(id)));
		//ȡ����������
		List<Comment> latests = commentBiz.findLatest((Integer.parseInt(id)));
		
		//�������ݲ���ת
		request.setAttribute("wenzhang", wenzhang);
		request.setAttribute("hots", hots);
		request.setAttribute("latests", latests);
		
		request.getRequestDispatcher("Article.jsp").forward(request, response);
		
		
	}

}
