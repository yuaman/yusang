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
		//1.�����ַ�����
		request.setCharacterEncoding("UTF-8");
		
		//2.��ȡ�����ݣ�����ҵ��
		String dengluMing = request.getParameter("username");	//��¼��
		String dengluMima = request.getParameter("userpwd"); 	//��½����
		
		Guanliyuan guanliyuan = new GuanliyuanBiz().findByMingHeMima(dengluMing, dengluMima);
			
		//3.��ʾ������
		if(guanliyuan != null){
			
			//out.print(guanliyuan.getMingzi() + ",���!");
			//�봫�ݵ�Ŀ��ҳ������ݴ洢����setAttribute(�ַ���,Object)
			HttpSession session = request.getSession();
			session.setAttribute("adminName", guanliyuan.getMingzi());
			
			//JSP��ͨ���������ҳ����ת
			//request������1.��ȡת����
			RequestDispatcher dispatcher = request.getRequestDispatcher("AdminIndex.jsp");
			dispatcher.forward(request, response);
			
		} else {
			
			//response �ض��� ֻ���ڲ������κ����ݵ�ʱ��ŵ��� 
					//response.sendRedirect("login.jsp");
					request.setAttribute("error", "�û��������벻��ȷ");
					
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
