package javaEE.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 创建session
 */
public class CreateSession extends HttpServlet {

	private static final long serialVersionUID = -5977051434188044734L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		HttpSession session = request.getSession();
		String val = (String) session.getAttribute("bSession");
		printWriter.println("读取到session值为：" + val);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter printWriter = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		session.setAttribute("bSession", "sessionB");
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(60 * 60 * 10);
		response.addCookie(cookie);
		printWriter.println("session created! attrbute: bSession, value: sessionB");
		printWriter.println("cookie added! (\"JSESSIONID\", \"session.getId()\")");
	}

}
