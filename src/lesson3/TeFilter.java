package lesson3;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * �����������ж�����γ����� ִ��˳�򣺰�����˳��ִ�� �����Դ������ʱ��������е����й��������ᱻ����ִ��
 * �κ�һ��������û��ͨ�����������жϣ�����������й�����������ִ��
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
