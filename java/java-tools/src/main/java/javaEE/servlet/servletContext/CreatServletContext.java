package javaEE.servlet.servletContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * serlvetContext
 */
public class CreatServletContext extends HttpServlet {

	private static final long serialVersionUID = -4965652427708598938L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		String name = this.getInitParameter("name");// 本servlet的
		String name1 = this.getServletConfig().getInitParameter("name");// 本servlet的
		String name2 = this.getServletContext().getInitParameter("name");// 全局的
		printWriter.println("servlet的初始化参数name=" + name + name1 + "<br/>servletContext的初始化参数name=" + name2 + "<br>");

		/** 获取servletContext对象 */
		ServletContext servletContext = this.getServletContext();
		// ServletContext servletContext2 =
		// this.getServletConfig().getServletContext();
		/** 添加对象 */
		servletContext.setAttribute("users", new Date().toString());
		printWriter.println("已经将访问时间记录到servletContext中" + "<br>");
		/** 获取对象 */
		String date = (String) servletContext.getAttribute("users");
		printWriter.println("获取到对象：" + date + "<br>");
		/** 删除对象 */
		servletContext.removeAttribute("users");

		// 下面的都是放在webapp/webRoot目录下
		InputStream inputStream = this.getServletContext().getResourceAsStream("/res/javaEE.servlet/dbRoot.properties");// 以webapp为/
		Properties properties = new Properties();
		properties.load(inputStream);
		String path = this.getServletContext().getRealPath("res/javaEE.servlet/dbRoot.properties");// 注意如果是tomcat发布会因打包拷贝改变真实路径
		printWriter.print("passwd1=" + properties.getProperty("passwd") + "<br>");
		printWriter.println("绝对路径为：" + path + "<br>");

		// 如果放在src目录下，应使用类加载器读取
		InputStream inputStream2 = this.getClass().getResourceAsStream("/servlet/db.properties");//以classpath包含的路径为根目录
		//InputStream inputStream2 = this.getClass().getClassLoader().getResourceAsStream("/javaEE.servlet/db.properties");//默认使用class文件的根目录
		Properties properties2 = new Properties();
		properties2.load(inputStream2);
		printWriter.print("passwd2=" + properties2.getProperty("passwd") + "<br>");
	}

}