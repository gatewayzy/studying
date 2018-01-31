package javaEE.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
remove cookie *
 */
public class RemoveCookie extends HttpServlet{

	private static final long serialVersionUID = -3881343575050474954L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie cookie = new Cookie("Acookie", new Date().toLocaleString());
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		out.println("已经删除cookie(\"Acookie\",登录时间)");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
