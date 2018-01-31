package javaEE.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * extends GenericServlet to realize a javaEE.servlet
 * 在web.xml中配置servlet访问，发布webapp并访问/webapp/url-pattern
 * 
 * @author dell
 *
 */
public class MyGenericServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.getWriter().println("hello GenericServlet:" + new Date());
	}

}
