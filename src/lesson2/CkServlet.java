package lesson2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 演示cookie
 * @author Administrator
 */

public class CkServlet extends HttpServlet {
	private int i = 0;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//cookie无状态性
		//out.println("访问的次数是：" + (++i));
		
		//cookie有状态性  浏览器之间的访问不影响对方的变量值
		int count=1;
		Cookie[] cks=request.getCookies();
		//如果浏览器第一次访问，没有cookie，响应一个cookie写入变量count的值为1
		if(cks==null ||cks.length==0){
			Cookie ck=new Cookie("count", count+"");
			response.addCookie(ck);
		}else{
		//判断这个cookie中是否有count这个变量，如果有count变量，把它的值加1写回浏览器
			for(Cookie c: cks){
				if(c.getName().equals("count")){
					count=Integer.valueOf(c.getValue())+1;
					response.addCookie(c);
				}
			}
			Cookie ck=new Cookie("count", count+"");
			response.addCookie(ck);						
		}
		
		out.println("你是第"+count+"次访问");
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
