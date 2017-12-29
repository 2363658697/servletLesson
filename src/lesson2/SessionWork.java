package lesson2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionWork extends HttpServlet {

	private int count = 1;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String cp = request.getContextPath(); // 上下文路径
		// session有状态
		HttpSession session = request.getSession();

		// 获取session中count的值
		Object obj = session.getAttribute("count");
		
		//通过获取参数来减少访问次数
		String minus = request.getParameter("minus");

		// 如果session中不存在count变量，设置count变量，值为1
		if (obj == null) {
			session.setAttribute("count", count);
		} else if (minus != null) {
			count = (Integer) obj - 2;
			//控制访问次数不为负数
			if(count<0){
				count=0;
			}
			session.setAttribute("count", count);
			//重定向到本文件
			response.sendRedirect(cp + "/sw");
		} else {
			count = (Integer) obj + 1;
			session.setAttribute("count", count);
		}
		
		out.println("你是第" + count + "次访问");
		//超链接带参数来控制访问次数的减少
		out.println("<a href=\"" + cp + "/sw?minus=1\"" + ">点击访问次数减1</a>");
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
