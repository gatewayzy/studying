package javaEE.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter{
	FilterConfig config;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("LogFilter init");
		this.config = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("LogFilter doFilter before chain.doFilter");
		ServletContext servletContext = this.config.getServletContext();
		System.out.println("filter就像特殊的servlet，也可读取servletContext，如：base为"+servletContext.getInitParameter("base"));
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		System.out.println("拦截到用户请求url：" + httpServletRequest.getServletPath());
		chain.doFilter(request, response);
		System.out.println("LogFilter doFilter after chain.doFilter");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("LogFilter destroy");
	}

}
