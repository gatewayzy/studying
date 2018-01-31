/**
 * 
 */
package javaEE.servlet.servletContext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 网站登录计数器
 * 
 * @author dell
 *
 */
public class Counter extends HttpServlet {
	private static final long serialVersionUID = 3683201066713386210L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		if (this.getServletContext().getAttribute("cnt") == null) {
			printWriter.println("你是第1个访客<br>");
			this.getServletContext().setAttribute("cnt", 1);
		} else {
			int cnt = (int) this.getServletContext().getAttribute("cnt");
			cnt++;
			this.getServletContext().setAttribute("cnt", cnt);
			printWriter.print("你是第" + cnt + "个访客");
		}

	}

}
