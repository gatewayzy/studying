package controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Startup implements Servlet {

	/**项目启动时运行
	 */
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("项目启动时就运行的一些工作，这里用servlet的load-on-startup实现");
	}

	@Override
	public void destroy() {

	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {

	}

}
