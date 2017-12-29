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
 * ����ת�����ض��������
 *  1.���÷�ʽ�� ת����request.getRequestDispatcher("�ļ�·��").forward(request,response);
 * 						 �ض���response.sendRedirect("������·����ͨ����Ӧͷ��ȡ��"+"�ļ�·��");
 * 2.��������� ת����һ�� �ض��򣺶���
 * 3.��ת��ʽ�� ת�����������ڲ���ת �ض��򣺸�֪�����302 ����location ����������ת
 * 4.��ַ��ͬ�� ת������ַ�����ض��򣺵�ַ�仯Ϊ�ڶ��ε�ַ 
 * 5.������ͬ�� ת������������ �ض��򣺲�����ʧ 
 * 6.������ʣ� ת����ֻ����ͬһ����Ŀ��url��ת �ض��򣺿��Կ���
 * 
 * @author Administrator
 *
 */

public class Mylogin extends HttpServlet {

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

		response.setContentType("text/html;charset=UTF-8"); // ���ñ���
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
			out.println(cp);

			// ������ת ����Ҫ���������·�� ���Դ�������·����
			// request.getRequestDispatcher("/lesson2/test.txt").forward(request, response);

			// �ض��� ��Ҫ���������·�� 
			response.sendRedirect(cp + "/lesson2/test.txt");

		} else {
			out.println("<font color=red>" + "�û�:" + username + "��¼ʧ��" + "</font>");
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
