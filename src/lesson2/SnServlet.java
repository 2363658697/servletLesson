package lesson2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * session��ʾ
 * 
 * @author Administrator
 *
 */

public class SnServlet extends HttpServlet {
	int count = 1;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// session��״̬
		HttpSession session = request.getSession();

		

		//��ȡsession��count��ֵ
		Object obj = session.getAttribute("count");
		//���session�в�����count����������count������ֵΪ1
		if(obj!=null){
			count=(Integer)obj+1;
			session.setAttribute("count", count);
		}else{		
			session.setAttribute("count", count);
		}
		out.println("���ǵ�"+count+"�η���");
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
