package lesson3;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
/**
 * 监听HttpServlet
 * request生命周期：浏览器发起请求产生request对象，响应后request被销毁
 * @author Administrator
 *
 */
public class RequestListence implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("请求被销毁");

	}

	public void requestInitialized(ServletRequestEvent arg0) {
		HttpServletRequest request=(HttpServletRequest)arg0.getServletRequest();
		System.out.println("产生请求"+request.getRequestURI());

	}

}
