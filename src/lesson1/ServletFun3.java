package lesson1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet生命周期：
 *  1.
 *  Tomcat容器会自动实例化servlet实例 （永远只有一个实例 --单实例 默认在第一次访问时实例化
 * 配置了load-on-startup>=0的值 启动服务时实例化 否则第一次请求超时 ）
 *  2.
 * Tomcat容器会自动调用init()方法进行简单的初始化， 只会调用一次
 *  3.
 *  service方法：请求的入口方式是service()方法 根据请求的类型决定调用doget和dopost 
 *  						service方法就是服务的方法，每发起一次请求就调用一次
 *  4.
 *  destroy方法： 当容器被关闭 或者被重新加载时  自动销毁servlet
 */
public class ServletFun3 extends HttpServlet {

	public ServletFun3() {
		System.out.println("构造方法");
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("service");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("hello");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public void init() throws ServletException {
		System.out.println("init");
	}

	/*
	 * public void init(ServletConfig config) throws ServletException {
	 * System.out.println("init带参数"); }
	 */

}
