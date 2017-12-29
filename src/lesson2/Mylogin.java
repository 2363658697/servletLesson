package lesson2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tools.DbUtils;

/**
 * 请求转发和重定向的区别：
 *  1.调用方式： 转发：request.getRequestDispatcher("文件路径").forward(request,response);
 * 						 重定向：response.sendRedirect("上下文路径（通过响应头获取）"+"文件路径");
 * 2.请求次数： 转发：一次 重定向：二次
 * 3.跳转方式： 转发：服务器内部跳转 重定向：告知浏览器302 设置location 发生二次跳转
 * 4.地址不同： 转发：地址不变重定向：地址变化为第二次地址 
 * 5.参数不同： 转发：参数保留 重定向：参数丢失 
 * 6.跨域访问： 转发：只能在同一个项目的url跳转 重定向：可以跨域
 * 
 * @author Administrator
 *
 */

public class Mylogin extends HttpServlet {

	Connection conn = null;

	/**
	 * 初始化servlet时获取Connection连接
	 */
	public void init() throws ServletException {
		try {
			conn = DbUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 代码执行完毕关闭Connection连接
	 */
	public void destroy() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取请求以及相应
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8"); // 设置编码
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username"); // 用户名
		String password = request.getParameter("password"); // 密码
		String cp = request.getContextPath(); // 上下文路径

		String sql = "select * from myusers where name= ? and password = ?";
		boolean bool = false;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			bool = rs.next();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if (bool) {
			out.println("<font color=green>" + "用户：" + username + "登录成功" + "</font>");
			out.println(cp);

			// 请求跳转 不需要添加上下文路径 （自带上下文路径）
			// request.getRequestDispatcher("/lesson2/test.txt").forward(request, response);

			// 重定向 需要添加上下文路径 
			response.sendRedirect(cp + "/lesson2/test.txt");

		} else {
			out.println("<font color=red>" + "用户:" + username + "登录失败" + "</font>");
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
