package lesson2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * session演示
 * 
 * @author Administrator
 *
 */

public class SnServlet extends HttpServlet {
	int count = 1;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// session有状态
		HttpSession session = request.getSession();

		

		//获取session中count的值
		Object obj = session.getAttribute("count");
		//如果session中不存在count变量，设置count变量，值为1
		if(obj!=null){
			count=(Integer)obj+1;
			session.setAttribute("count", count);
		}else{		
			session.setAttribute("count", count);
		}
		out.println("你是第"+count+"次访问");
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
