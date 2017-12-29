package lesson1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * refresh 缓存 重定向
 */
public class ServletFun2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		out.println("aaa");

		// 地址重定向：指向新的地址 301/302：重定向 永久、临时
		// response.setStatus(301);
		// response.setHeader("Location","地址" );

		// 间隔一段时间后跳转页面 refresh
		response.setIntHeader("refresh", 10);
		response.setHeader("refresh", "2;地址");

		// 不使用缓存跳转：搜索响应头不使用缓存
		response.setDateHeader("expries", -1);
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("refresh", "2;");
	}

}
