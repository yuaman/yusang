package com.ys.before;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ys.biz.FenleiBiz;
import com.ys.common.Common;
import com.ys.entity.Fenlei;

public class InitFenleiViewSerlet extends HttpServlet{

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
		 
		String p = request.getParameter("p");
		if(Common.isNotANumber(p)){
			p = "1";
		}
		
	        List<Fenlei> fenleis = new FenleiBiz().findFenleiByPage(Integer.parseInt(p));
	        int FenleiTotal =  new FenleiBiz().findCount();
	        double TempPageAmount = Math.ceil((double)FenleiTotal/Common.ADMIN_FENLEIPERPAGE_NUM);
	        String pageLinkContent = Common.createPageLinkContent(Integer.parseInt(p), TempPageAmount, "initfenleiview");
	        
	           
	        request.setAttribute("fenleis", fenleis);
	        request.setAttribute("pagelinkcnt", pageLinkContent);
	        
	        request.getRequestDispatcher("FenleiView.jsp").forward(request, response);
	}

}
