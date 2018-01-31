package javaEE.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**测试数据库连接listener
 * @author dell
 *
 */
public class TestDBListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("TestDBListener contextInitialized，测试数据库配置、日志记录的配置等");
		String base = sce.getServletContext().getInitParameter("base");
		System.out.println("listener也可以读取servletContext的值，如base："+base);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("TestDBListener contextDestroyed，项目正常关闭，释放资源等");
	}

}
