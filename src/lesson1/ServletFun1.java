package lesson1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��ȡ��Ӧͷ��Ϣ
 * ��Ҫ����ȡ������·��  			��ȡurl 
 * 			getContextPath()      getRequestURI()		
 */
public class ServletFun1 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// ��ȡurl *******
		String url = request.getRequestURI();
		out.println("��ȡ��URL��" + url + "<br/>");

		// ��ȡ����
		String username = request.getParameter("username");
		out.println("��ȡ�Ĳ�����" + username + "<br/>");
		// ��ȡ����ķ�ʽ
		String method = request.getMethod();
		out.println("����ʽ��" + method + "<br/>");
		// ��ȡ����ͷ�ļ�ֵ��
		String al = request.getHeader("Accept-Language");
		out.println("֧�ֵĹ��Һ����ԣ�" + al + "<br/>");

		// ��ȡ������·�� ********
		String cp = request.getContextPath();
		out.println("������·����" + cp + "<br/>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
