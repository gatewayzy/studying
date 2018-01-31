package javaEE.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 继承HttpServlet，发布项目，访问相应的html直接post
 */
public class MyHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 8020940240259361429L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().println("doGet...");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().println("doPost: userName = " + request.getParameter("userName"));
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("MyHttpServlet中设置初始编码为："+this.getServletConfig().getInitParameter("encoding"));
	}

}
