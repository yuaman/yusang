package com.ys.before;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.oracle.jrockit.jfr.RequestableEvent;
import com.sun.jmx.snmp.tasks.Task;
import com.ys.biz.FenleiBiz;
import com.ys.entity.Fenlei;

/**
 * Servlet implementation class InitFeileiAdd
 */
@WebServlet("/InitFeileiAdd")
public class InitFenleiAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		
		//防止重复提交操作
		HttpSession settion = request.getSession();
		
		String token = "tk"+new Random().nextInt(200);
		  //打包
		settion.setAttribute("tk",token);
		 
	    			
		//分类显示操作
		List<Fenlei> fenleis = new FenleiBiz().findAllShownRoot();
		request.setAttribute("fenleis", fenleis);
		request.getRequestDispatcher("FenleiAdd.jsp").forward(request, response);
		
		
		
		
		
	}

}
