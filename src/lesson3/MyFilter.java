package lesson3;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.ARG_OUT;

/**
 * 拦截器的实现：实现Filter 拦截器只能在容器启动时创建实例
 * 
 * @author Administrator
 *
 */
public class MyFilter implements Filter {

	public void destroy() {

	}

	/**
	 * 配置了拦截某些资源，这些资源都进入FilterChain对象调用的doFilter方法，该方法决定了 是否能通过该过滤器 设置编码格式
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse rep = (HttpServletResponse) arg1;

		rep.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		rep.setContentType("text/html");

		String url = req.getRequestURI();
		if (!url.contains("a")) {
			arg2.doFilter(arg0, arg1);
		}

	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
