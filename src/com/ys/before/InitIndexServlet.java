package com.ys.before;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;
import com.sun.swing.internal.plaf.metal.resources.metal;
import com.ys.biz.FenleiBiz;
import com.ys.biz.MenuBiz;
import com.ys.entity.Fenlei;
import com.ys.entity.Menu;

public class InitIndexServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest  request, HttpServletResponse response) throws ServletException, IOException {
		//前台及各文章页头部菜单栏显示
		MenuBiz menuBiz = new MenuBiz();
		List<Menu> menus = menuBiz.findMenu();
		HttpSession session = request.getSession();
		session.setAttribute("menus", menus);
		
	    //首页父分类及子分类循环输出显示
	    FenleiBiz fenleiBiz = new FenleiBiz();
	    Map<Fenlei, List<Fenlei>> fenleimap = fenleiBiz.findIndexAll();
	    request.setAttribute("fenleimap", fenleimap);
	    
	  
	    request.getRequestDispatcher("Index.jsp").forward(request, response);
	    
	   
	}
            
}
