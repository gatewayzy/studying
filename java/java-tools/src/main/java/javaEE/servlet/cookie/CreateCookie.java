package javaEE.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *创建cookie 
 */
public class CreateCookie extends HttpServlet{

	private static final long serialVersionUID = 983149615370805275L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String loginTime = new Date().toLocaleString();
		Cookie cookie = new Cookie("Acookie", loginTime);
		cookie.setMaxAge(60*60);//s
		response.setContentType("text/html;charset=utf-8");
		response.addCookie(cookie);//http响应头中添加set-cookie信息
		PrintWriter out = response.getWriter();
		out.println("cookie created，本次登录时间是"+loginTime);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}
	
}
