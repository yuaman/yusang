package com.ys.Ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.ys.biz.CommentBiz;
import com.ys.common.Common;
import com.ys.entity.Comment;
import com.ys.entity.Wenzhang;
import com.ys.entity.Yonghu;

public class AjaxAddCommentServerlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Common.CHARSET);
		
		String wenzhangId = request.getParameter("wzid");
		String neirong = request.getParameter("nr");
		
		Yonghu yonghu = (Yonghu)request.getSession().getAttribute("yonghu");
		
		Wenzhang wenzhang = new Wenzhang();
		Comment pinglun = new Comment();
		
		int wId = Integer.parseInt(wenzhangId);
		
		wenzhang.setId(wId);
		pinglun.setWenzhang(wenzhang);
		pinglun.setNeirong(neirong);
		pinglun.setYonghu(yonghu);
		
		new CommentBiz().add(pinglun);
		
		PrintWriter out  = response.getWriter();
		String pingLunJieGuo = "<li class='pinglun'><p class='title'><span class='mingzi'>[nicheng]</span><span class='shijian'>[shijian]</span></p><p class='nr'>[neirong]</p><p class='zan'><span>[zan]</span><a href='javascript:void(0)' class='zan-href' data-id='[id]'>璧�/a></p></li>";
		pingLunJieGuo = pingLunJieGuo.replace("[nicheng]", yonghu.getNicheng());
		pingLunJieGuo = pingLunJieGuo.replace("[shijian]", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		pingLunJieGuo = pingLunJieGuo.replace("[neirong]", neirong);
		pingLunJieGuo = pingLunJieGuo.replace("[zan]", 0+"");
		pingLunJieGuo = pingLunJieGuo.replace("[id]", 897+"");
		
		
		out.print(pingLunJieGuo);
		out.flush();
		out.close();
		
		
				
				
		
		
	}

}
