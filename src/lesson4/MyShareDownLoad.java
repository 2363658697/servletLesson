package lesson4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.Filter;


public class MyShareDownLoad extends HttpServlet {

	// 下载文件的存放路径
		static String SAVE_DIR = "E:/test";

	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		
		//文件上传的操作执行在UploadServlet类中
		out.println("<form action=\"upload\" method=\"post\" enctype=\"multipart/form-data\">");	
		out.println("<input type=\"text\" name=\"myfile\" size=\"50\" /> <br/> ");
		out.println("<br/>");
		out.println("<input type=\"file\" name=\"file\"size=\"50\" />   <br/>");
		out.println(" <br/> ");
		out.println("	<input type=\"submit\" value=\"上传文件\" /></form>");

		
		File file=new File(SAVE_DIR);
		File[] files=file.listFiles();
		for(File f:files){
			if(f.isFile()){
				out.println("<a href='share?fileName="+f.getName()+"'>"+f.getName()+"</a>"+"<br/>");
			}
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
