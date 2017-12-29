package lesson4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {
	// 上传文件的存放路径
	static String SAVE_DIR = "E:/test";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		// 接收文件
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		// 判断是否是文件上传请求
		if (isMultipart) {
			// 用户创建解析文件上传的工厂类
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 默认上传文件 暂时存放在临时目录 System.getProperty("java.io.tmpdir);
			// 或者是Tomcat/temp目录

			// 用于从请求中解析文件
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 设置字符编码
			upload.setHeaderEncoding("utf-8");

			try {
				// 解析接收的是文件还是文本框
				List<FileItem> items = upload.parseRequest(request);
				// 打印上传的文件个数
				// System.out.println(fileItems.size());
				for (FileItem item : items) {
					// 判断是否是文本框
					if (item.isFormField()) {
						System.out.println(item.getFieldName() + "-------" + item.getString());
					} else {
						// 获取上传的文件名
						String fileName = item.getName();
						// 文件保存路径
						String destPath = SAVE_DIR + "/" + fileName;

						System.out.println(destPath);
						// 获取输入流
						InputStream iStream = item.getInputStream();
						// 定义输出流，将上传的文件保留在服务器
						FileOutputStream fOutputStream = new FileOutputStream(destPath);
						byte[] bs = new byte[1024];
						int read = -1;
						while ((read = iStream.read(bs)) != -1) {
							fOutputStream.write(bs, 0, read);
						}
						// 关闭流通道
						iStream.close();
						fOutputStream.close();

					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}

		}
		//文件上传完重定向到MyShareDownLoad类中
		response.sendRedirect(request.getContextPath() + "/share");

	}

}
