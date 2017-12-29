package lesson3;
/**
 * ¼àÌýHttpSessionAttributeListener
 */
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionDataChange implements HttpSessionAttributeListener {


	public void attributeAdded(HttpSessionBindingEvent arg0) {
		String key=arg0.getName();
		String value=arg0.getValue().toString();
		System.out.println(key+"---"+value);

	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
			
	}

	
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		String key=arg0.getName();
		String value=arg0.getValue().toString();
		String nString=arg0.getSession().getAttribute(key).toString();
		System.out.println(key+"--"+value+"--"+nString);

	}

}
