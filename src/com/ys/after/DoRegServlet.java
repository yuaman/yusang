package com.ys.after;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ys.biz.YonghuBiz;
import com.ys.common.Common;
import com.ys.entity.Yonghu;


public class DoRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getSession().getServletContext().getRealPath("/");

		System.out.println(path);

		try {
			
			DiskFileItemFactory uploadFactory = new DiskFileItemFactory();

			ServletFileUpload upload = new ServletFileUpload(uploadFactory);

			List<FileItem> items = upload.parseRequest(request);

			
			Yonghu yh = new Yonghu();

			for (FileItem item : items) {

				
				if ("touxiang".equals(item.getFieldName())) {
					
					String fileName = item.getName();
					
					String suffix = fileName.substring(fileName.lastIndexOf("."));
					
					long now = System.currentTimeMillis();
					
					String newFileName = "thumb" + now  + suffix;

					
					File file = new File(path + "/upload/" + newFileName);
					item.write(file);
					
					yh.setTouxiang("/upload/" + newFileName);
					
				} else {
					
					switch (item.getFieldName()) {
					case "username":
						yh.setDengluMing(item.getString("UTF-8"));
						break;
					case "userpwd":
						yh.setDengluMima(item.getString("UTF-8"));
						break;
					case "nicheng":
						yh.setNicheng(item.getString("UTF-8"));
						break;
					case "xingbie":
						yh.setXingbie(Integer.parseInt(item.getString("UTF-8")));
						break;
					case "aihao":
						yh.setAihao(yh.getAihao() + "," + item.getString("UTF-8"));
						break;
					
					}

				}
			}

			
			 YonghuBiz yonghuBiz = new YonghuBiz();
			 boolean res = yonghuBiz.reg(yh);
			 
			 response.sendRedirect("admin/userlist.jsp");

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
