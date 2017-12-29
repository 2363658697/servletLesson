package lesson3;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * ����HttpSession session�������ڣ� 
 * 1.
 * sessionԭ����ͨ�������ڵ���getSession()ʱ�Զ�ͨ��cookieд��sessionId�ķ�ʽ������
 *  2.
 * cookieĬ�ϵ���Ч������������ر�֮ǰ����ǰsession����Ч���ǵ�ǰ��һ�����������
 *  3.
 * session���ݴ���������У������޷�������������Ĺرջ�ͨ�� web.xml�ļ��� <session-config>
 * <session-timeout>������</session-timeout> </session-config>
 * ��������ʱ�������δ���ʵ�session����
 */
public class SessionListence implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		System.out.println("����session����" + session.getId());

	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		System.out.println("����session����" + session.getId());
	}

}
