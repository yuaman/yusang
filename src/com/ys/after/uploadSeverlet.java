package com.ys.after;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ys.entity.Yonghu;

/**
 * Servlet implementation class uploadSeverlet
 */
@WebServlet("/upload")
public class uploadSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadSeverlet() {
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

				String path = request.getSession().getServletContext().getRealPath("/");

				System.out.println(path);

				try {
					
					DiskFileItemFactory uploadFactory = new DiskFileItemFactory();

					ServletFileUpload upload = new ServletFileUpload(uploadFactory);

					List<FileItem> items = upload.parseRequest(request);

					
					Yonghu yh = new Yonghu();
					String newFileName = null;
					for (FileItem item : items) {

						String fileName = item.getName();
				
						String suffix = fileName.substring(fileName.lastIndexOf("."));

						long now = System.currentTimeMillis();

						newFileName = "thumb" + now + suffix;

						File file = new File(path + "/upload/" + newFileName);
						item.write(file);

						yh.setTouxiang("/upload/" + newFileName);

					}
					HttpSession session = request.getSession();
					session.setAttribute("imgsrc", "upload/" + newFileName);
					request.getRequestDispatcher("image.jsp").forward(request, response);
					
				} catch (FileUploadException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}


