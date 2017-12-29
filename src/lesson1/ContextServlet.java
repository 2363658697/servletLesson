package lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ������ʹ��--------- ȫ�֣�ServletContext �ֲ���ServletConfig
 */
public class ContextServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// ȫ�ֱ���
		ServletContext sc = this.getServletContext();
		sc.log("��ʼ��־");

		// 1.servlet֮�乲������
		sc.setAttribute("name", "ssg"); //������servlet�ж���ServletContext ͨ�� getAttribute("name")��ȡ����
		// 2.��ȡweb.xml�����õĲ��� context-param
		String age = sc.getInitParameter("age");
		out.println("��ȡ�Ĳ�����" + age + "<br/>");
		// 3.��ȡweb��Դ
		InputStream is = sc.getResourceAsStream("/test.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "GBK"));
		out.println("��ȡ����Դ��" + br.readLine() + "<br/>");
		is.close();
		br.close();
		// 4.��ӡ��־
		sc.log("������־");

		// ʹ��config��ȡ����servlet���� ���ֲ��� �ڱ����servlet�����init-param
		String address = config.getInitParameter("address");
		out.println("��ȡ����ֲ�������" + address + "<br/>");

		out.close();
	}

	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		super.init(config);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
