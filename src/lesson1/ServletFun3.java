package lesson1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet�������ڣ�
 *  1.
 *  Tomcat�������Զ�ʵ����servletʵ�� ����Զֻ��һ��ʵ�� --��ʵ�� Ĭ���ڵ�һ�η���ʱʵ����
 * ������load-on-startup>=0��ֵ ��������ʱʵ���� �����һ������ʱ ��
 *  2.
 * Tomcat�������Զ�����init()�������м򵥵ĳ�ʼ���� ֻ�����һ��
 *  3.
 *  service�������������ڷ�ʽ��service()���� ������������;�������doget��dopost 
 *  						service�������Ƿ���ķ�����ÿ����һ������͵���һ��
 *  4.
 *  destroy������ ���������ر� ���߱����¼���ʱ  �Զ�����servlet
 */
public class ServletFun3 extends HttpServlet {

	public ServletFun3() {
		System.out.println("���췽��");
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("service");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("hello");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public void init() throws ServletException {
		System.out.println("init");
	}

	/*
	 * public void init(ServletConfig config) throws ServletException {
	 * System.out.println("init������"); }
	 */

}
