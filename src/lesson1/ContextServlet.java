package lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 变量的使用--------- 全局：ServletContext 局部：ServletConfig
 */
public class ContextServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 全局变量
		ServletContext sc = this.getServletContext();
		sc.log("开始日志");

		// 1.servlet之间共享数据
		sc.setAttribute("name", "ssg"); //其他的servlet中定义ServletContext 通过 getAttribute("name")获取数据
		// 2.获取web.xml中配置的参数 context-param
		String age = sc.getInitParameter("age");
		out.println("获取的参数：" + age + "<br/>");
		// 3.读取web资源
		InputStream is = sc.getResourceAsStream("/test.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "GBK"));
		out.println("获取的资源：" + br.readLine() + "<br/>");
		is.close();
		br.close();
		// 4.打印日志
		sc.log("结束日志");

		// 使用config获取自身servlet变量 （局部） 在本类的servlet中添加init-param
		String address = config.getInitParameter("address");
		out.println("获取自身局部变量：" + address + "<br/>");

		out.close();
	}

	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		super.init(config);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
