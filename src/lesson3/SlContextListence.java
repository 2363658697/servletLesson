package lesson3;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * ServletContext���������ڣ�������Ӧ�õķ����������� �͹رգ����٣�
 * @author Administrator
 *
 */
public class SlContextListence implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("�����Ķ�������");

	} 

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("�����Ķ������");
	}
}
