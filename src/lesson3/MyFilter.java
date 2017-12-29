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
 * ��������ʵ�֣�ʵ��Filter ������ֻ������������ʱ����ʵ��
 * 
 * @author Administrator
 *
 */
public class MyFilter implements Filter {

	public void destroy() {

	}

	/**
	 * ����������ĳЩ��Դ����Щ��Դ������FilterChain������õ�doFilter�������÷��������� �Ƿ���ͨ���ù����� ���ñ����ʽ
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
