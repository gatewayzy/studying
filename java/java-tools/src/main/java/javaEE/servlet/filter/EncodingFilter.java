package javaEE.servlet.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 编码过滤器
 * 
 * @author dell
 *
 */
public class EncodingFilter implements Filter {
	private String encoding;
	private Map<String, String> params = new HashMap<>();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 在web.xml中被调用后读取参数等设置
		System.out.println("EncodingFilter init，读取相应资源");
		encoding = filterConfig.getInitParameter("encoding");
		System.out.println("encoding: "+encoding);
		for (Enumeration<?> e = filterConfig.getInitParameterNames(); e.hasMoreElements();) {
			String name = (String) e.nextElement();
			String value = filterConfig.getInitParameter(name);
			params.put(name, value);
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("EncodingFilter doFilter before chain.doFilter");
		request.setCharacterEncoding(encoding);
		// 将请求进行链式处理，将根据web.xml的配置执行下一个filter。
		chain.doFilter(request, response);
		// 调用的filter可以再链式处理。链式处理完成后才会继续执行本程序。
		System.out.println("EncodingFilter doFilter after chain.doFilter");
	}

	@Override
	public void destroy() {
		// 项目正常关闭时调用
		System.out.println("EncodingFilter destroy，释放相应资源");
		encoding = null;
		params = null;
	}

}
