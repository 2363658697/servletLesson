package lesson1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tools.DbUtils;

public class Work extends HttpServlet {

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

		response.setContentType("text/html;charset=UTF-8"); //设置编码
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
			destroy();
		} else {
			out.println("<font color=red>" + "用户:" + username + "登录失败" + "</font>");
			//验证信息不通过跳转会登陆页面
			response.setDateHeader("expries", -1);
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("refresh", "2;url=" + cp + "/d.html");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
