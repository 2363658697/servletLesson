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
	 * ��ʼ��servletʱ��ȡConnection����
	 */
	public void init() throws ServletException {
		try {
			conn = DbUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * ����ִ����Ϲر�Connection����
	 */
	public void destroy() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��ȡ�����Լ���Ӧ
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8"); //���ñ���
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username"); // �û���
		String password = request.getParameter("password"); // ����
		String cp = request.getContextPath(); // ������·��

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
			out.println("<font color=green>" + "�û���" + username + "��¼�ɹ�" + "</font>");
			destroy();
		} else {
			out.println("<font color=red>" + "�û�:" + username + "��¼ʧ��" + "</font>");
			//��֤��Ϣ��ͨ����ת���½ҳ��
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
