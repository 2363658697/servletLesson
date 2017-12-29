package lesson1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取响应头信息
 * 重要：获取上下文路径  			获取url 
 * 			getContextPath()      getRequestURI()		
 */
public class ServletFun1 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 获取url *******
		String url = request.getRequestURI();
		out.println("获取的URL：" + url + "<br/>");

		// 获取参数
		String username = request.getParameter("username");
		out.println("获取的参数：" + username + "<br/>");
		// 获取请求的方式
		String method = request.getMethod();
		out.println("请求方式：" + method + "<br/>");
		// 获取请求头的键值对
		String al = request.getHeader("Accept-Language");
		out.println("支持的国家和语言：" + al + "<br/>");

		// 获取上下文路径 ********
		String cp = request.getContextPath();
		out.println("上下文路径：" + cp + "<br/>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
