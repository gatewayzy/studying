package javaEE.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * read cookie
 */
public class ReadCookie extends HttpServlet {

	private static final long serialVersionUID = -6788467837325200672L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		boolean flag = false;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("Acookie")) {
				out.println("cookie found，上次登录时间是" + cookie.getValue());
				flag = true;
				break;
			}
		}
		if (!flag) {
			out.println("没有发现上次登录cookie");
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
