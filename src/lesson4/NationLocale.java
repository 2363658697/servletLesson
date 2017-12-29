package lesson4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��ȫ����java���ʻ� �������� 
 * 1.������Դ�ļ� BASENAME_���Դ���_������.properties
 * 2.ͨ��request.getLocale() ��ȡLocale���� 
 * 3.ͨ��ResourceBundle resb1 =ResourceBundle.getBundle(" BASENAME ", request.getLocale());
 * 4.ͨ��resb1.getString(��keyֵ��)��ȡ����
 * @author Administrator
 *
 */
public class NationLocale extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// Locale local=request.getLocale();

		ResourceBundle resb = ResourceBundle.getBundle("lesson4/test", request.getLocale().US);

		out.print(resb.getString("hello"));

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
