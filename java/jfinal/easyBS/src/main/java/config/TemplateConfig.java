package config;


import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.cron4j.Cron4jPlugin;
import com.jfinal.render.ViewType;

import com.jfinal.template.Engine;
import controller.IndexController;
import controller.interceptor.LogAopIntc;
import controller.web.classStudent.ClassesController;
import controller.web.classStudent.StudentController;
import service.MyJsoup;

public class TemplateConfig extends JFinalConfig{

	@Override
	/*常量值*/
	public void configConstant(Constants me) {
		//这些都可以使用JFinal自动生成模板，再参考JFianl手册
		me.setDevMode(true);//选择开发模式，输出每次请求报告
		me.setEncoding("UTF-8");//项目编码
		me.setViewType(ViewType.JSP);//选择默认视图类型为jsp
	}

	/*访问路由*/
	@Override
	public void configRoute(Routes me) {
		me.add("/", IndexController.class);
		me.add("/index", IndexController.class);
		me.add("/classes",ClassesController.class);
		me.add("/student", StudentController.class);
		//疾病标注
		//me.add("/disLabel",DisLabel20161209.class);
	}

	@Override
	public void configEngine(Engine engine) {

	}

	@Override
	/*插件*/
	public void configPlugin(Plugins me) {
		// 插件Cron4jPlugin 是jfinal3.0支持的
		Cron4jPlugin cron4jPlugin = new Cron4jPlugin();
		cron4jPlugin.addTask("* * * * *", new MyJsoup());  // cron and runnable task
		me.add(cron4jPlugin);
		
		/*读取配置文件，默认路径为 src/main/resources*/
		loadPropertyFile("mysqlTempl.txt");
		/*启用C3p0数据库连接池插件，也可以使用DruidPlugin插件*/
		C3p0Plugin cp = new C3p0Plugin(getProperty("url"), getProperty("user"), getProperty("password"));
		me.add(cp);
		/*启用ActiveRecord数据库访问插件*/
		ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
		me.add(arp);
		/*配置数据库访问*/
		//arp.addMapping("student", "stuID",Student.class);
		//arp.addMapping("classes","claID", Classes.class);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		/*全局拦截器*/
		System.out.println("配置拦截器...");
		me.add(new LogAopIntc());
	}

	@Override
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler("basePath"));
	}

}
