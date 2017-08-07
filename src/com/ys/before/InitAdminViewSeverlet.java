package com.ys.before;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ys.biz.AdminBiz;
import com.ys.biz.FenleiBiz;
import com.ys.common.Common;
import com.ys.entity.Admin;
import com.ys.entity.Fenlei;

/**
 * Servlet implementation class InitAdminViewSeverlet
 */
@WebServlet("/initAdminView")
public class InitAdminViewSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitAdminViewSeverlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String p = request.getParameter("p");
        if(Common.isNotANumber(p)){
	            p="1";
           }
        List<Admin> admins = new AdminBiz().findAdminByPage(Integer.parseInt(p));
        int AdminTotal =  ((AdminBiz) new AdminBiz()).findCount();
        double TempPageAmount = Math.ceil((double)AdminTotal/Common.ADMIN_PERPAGE_NUM);
        String pageLinkContent = Common.createPageLinkContent(Integer.parseInt(p), TempPageAmount, "initAdminView");
        
           
        request.setAttribute("admins", admins);
        request.setAttribute("pagelinkcnt", pageLinkContent);
        
        request.getRequestDispatcher("AdminView.jsp").forward(request, response);
	}

}
