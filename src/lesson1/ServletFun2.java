package lesson1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * refresh ���� �ض���
 */
public class ServletFun2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		out.println("aaa");

		// ��ַ�ض���ָ���µĵ�ַ 301/302���ض��� ���á���ʱ
		// response.setStatus(301);
		// response.setHeader("Location","��ַ" );

		// ���һ��ʱ�����תҳ�� refresh
		response.setIntHeader("refresh", 10);
		response.setHeader("refresh", "2;��ַ");

		// ��ʹ�û�����ת��������Ӧͷ��ʹ�û���
		response.setDateHeader("expries", -1);
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("refresh", "2;");
	}

}
