package lesson4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 完全依赖java国际化 步骤如下 
 * 1.定义资源文件 BASENAME_语言代码_国家码.properties
 * 2.通过request.getLocale() 获取Locale对象 
 * 3.通过ResourceBundle resb1 =ResourceBundle.getBundle(" BASENAME ", request.getLocale());
 * 4.通过resb1.getString(“key值”)获取数据
 * @author Administrator
 *
 */
public class NationLocale extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// Locale local=request.getLocale();

		ResourceBundle resb = ResourceBundle.getBundle("lesson4/test", request.getLocale().US);

		out.print(resb.getString("hello"));

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
