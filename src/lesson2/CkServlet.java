package lesson2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��ʾcookie
 * @author Administrator
 */

public class CkServlet extends HttpServlet {
	private int i = 0;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//cookie��״̬��
		//out.println("���ʵĴ����ǣ�" + (++i));
		
		//cookie��״̬��  �����֮��ķ��ʲ�Ӱ��Է��ı���ֵ
		int count=1;
		Cookie[] cks=request.getCookies();
		//����������һ�η��ʣ�û��cookie����Ӧһ��cookieд�����count��ֵΪ1
		if(cks==null ||cks.length==0){
			Cookie ck=new Cookie("count", count+"");
			response.addCookie(ck);
		}else{
		//�ж����cookie���Ƿ���count��������������count������������ֵ��1д�������
			for(Cookie c: cks){
				if(c.getName().equals("count")){
					count=Integer.valueOf(c.getValue())+1;
					response.addCookie(c);
				}
			}
			Cookie ck=new Cookie("count", count+"");
			response.addCookie(ck);						
		}
		
		out.println("���ǵ�"+count+"�η���");
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
