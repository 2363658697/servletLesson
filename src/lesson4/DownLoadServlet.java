package lesson4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownLoadServlet extends HttpServlet {
	// 下载文件的存放路径
	static String SAVE_DIR = "E:/test";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String fileName = "servlet常用功能.txt";
		
		if(request.getParameter("fileName")!=null){
			fileName=request.getParameter("fileName");
		}
		
		System.out.println(fileName);
		
		
		// 文件下载路径
		String destPath = SAVE_DIR + "/" + fileName;
		//URLEncoder.encode(fileName,"UTF-8")
		// 告诉浏览器下载的文件名
		response.setHeader("Location",URLEncoder.encode(fileName, "UTF-8"));
		response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
		// 文件下载的输出流
		OutputStream os = response.getOutputStream();

		FileInputStream fis = new FileInputStream(destPath);
		byte[] bu = new byte[2049];
		int i = 0;
		while ((i = fis.read(bu)) != -1) {
			os.write(bu, 0, i);
		}
		os.flush();
		os.close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
