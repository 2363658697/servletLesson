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

		String cp = request.getContextPath(); // ������·��
		// session��״̬
		HttpSession session = request.getSession();

		// ��ȡsession��count��ֵ
		Object obj = session.getAttribute("count");
		
		//ͨ����ȡ���������ٷ��ʴ���
		String minus = request.getParameter("minus");

		// ���session�в�����count����������count������ֵΪ1
		if (obj == null) {
			session.setAttribute("count", count);
		} else if (minus != null) {
			count = (Integer) obj - 2;
			//���Ʒ��ʴ�����Ϊ����
			if(count<0){
				count=0;
			}
			session.setAttribute("count", count);
			//�ض��򵽱��ļ�
			response.sendRedirect(cp + "/sw");
		} else {
			count = (Integer) obj + 1;
			session.setAttribute("count", count);
		}
		
		out.println("���ǵ�" + count + "�η���");
		//�����Ӵ����������Ʒ��ʴ����ļ���
		out.println("<a href=\"" + cp + "/sw?minus=1\"" + ">������ʴ�����1</a>");
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
