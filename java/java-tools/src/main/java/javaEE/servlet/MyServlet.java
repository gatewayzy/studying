package javaEE.servlet;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * implements Servlet to realize a javaEE.servlet
 * 在web.xml中配置servlet访问，发布webapp并访问/webapp/url-pattern
 * @author dell
 *
 */
public class MyServlet implements Servlet{
	
	/** 该函数用于初始化servlet，就是把servlet类加载到内存中，该函数之后执行一次
	 * @param config
	 */
	public void init(ServletConfig config) throws ServletException{
		TestThread testThread = new TestThread();
		testThread.run();
	}
	
	/**获取servletConfig对象
	 * @return
	 */
	public ServletConfig getServletConfig() {
		return null;
	}
	
	/**该函数是服务函数，实现业务逻辑，每次服务都会被调用
	 */
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException{
		System.out.println("hello...");
		res.getWriter().println("hello!");
	}
	
	/**获取servlet的配置信息
	 * @return
	 */
	public String getServletInfo() {
		return null;
	}
	
	/**
	 * 销毁该servlet，从内存中清除，只调用一次
	 */
	public void destroy() {
		
	}

}
