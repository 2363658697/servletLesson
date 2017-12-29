package lesson3;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * 过滤器可以有多个，形成链： 执行顺序：按配置顺序执行 如果资源被访问时，这个链中的所有过滤器都会被依次执行
 * 任何一个过滤器没有通过，链条被中断，链条后的所有过滤器都不会执行
 * 
 * @author Administrator
 *
 */
public class TeFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("5555555555555");
		arg2.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
