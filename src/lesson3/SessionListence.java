package lesson3;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * 监听HttpSession session生命周期： 
 * 1.
 * session原理是通过容器在调用getSession()时自动通过cookie写入sessionId的方式来控制
 *  2.
 * cookie默认的有效期是浏览器被关闭之前，当前session的有效期是当前这一次浏览器访问
 *  3.
 * session数据存放在容器中，容器无法监听，浏览器的关闭会通过 web.xml文件的 <session-config>
 * <session-timeout>分钟数</session-timeout> </session-config>
 * 来决定定时清除长期未访问的session数据
 */
public class SessionListence implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		System.out.println("产生session对象：" + session.getId());

	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		System.out.println("销毁session对象" + session.getId());
	}

}
