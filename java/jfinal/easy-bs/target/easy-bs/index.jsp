<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${initParam.resources}/static/css/commonpages/common.css">
<title>index</title>
</head>
<body>
	<h3 align="center">这是项目的index界面</h3>
	<div>
		<h4>建立Maven工程</h4>
		<ol>
			<li>建立Maven Project -> creat a simple... -> 填id、war</li>
			<li>没有webapp目录的话，新建就好了，然后把web.xml也填写一下。内含重要路由配置</li>
			<li>配置好数据库文件</li>
		</ol>
	</div>
	<div>
		<h4>JFianl配置</h4>
		<ol>
			<li>render方法默认的文件路径在property的deployment配置中的/目录下。</li>
			<li>使用@ActionKey("/actionkey")注解方式也可以实现路由映射。那么之前如果是“/classes/actionkey”将变成“/actionkey”</li>
			<li>路由映射的结构为("/controllerKey/method/para0-para1")，其中index方法是默认的action。
		</ol>
	</div>
	<div>
		<h4>项目路由问题</h4>
		<ul>
			<li><strong>描述：</strong> 虽然配置了jfinal的config，但是无法访问路由路径</li>
			<li><strong>解决：</strong> 不管使用tomcat还是jetty进行发布项目时，他们都只是项目的容器。<br>
				这些容器的入口都是WEB-INF里面的web.xml，所以要进行配置filter、filter-mapping、servlet等路由配置。<br>
				web.xml文件含有welcome-file-list等许多重要配置，详情这里省略<br>
				web.xml将jfinal的入口config.java配置好，经过JFinalFilter（实例化）之后，接收Web请求。
			</li>
		</ul>
		
		<h4>maven、JFinal、jetty、tomcat的关系</h4>
		<ul>
			<li><strong>描述：</strong> 各自的功能和作用</li>
			<li><strong>解决：</strong> maven主要是依赖库的管理很方便，不用maven的话，需要手动添加jar包，难以同步<br>
				JFinal是开发架构，编写代码简单，尤其是DB操作，请求处理<br>
				jetty是开源的servlet容器，为java提供web容器，和tomcat都可以发布maven构建的项目<br>
				tomcat也是一个开源的web容器，此外还有JBoss、WebLogic等等容器<br>
			</li>
		</ul>

		<h4>dynamic web无法从2.3转换到3.0</h4>
		<ul>
			<li><strong>描述：</strong> 提示dynamic web无法转换版本</li>
			<li><strong>解决：</strong> 将项目文件夹中.setting文件夹下的xml文件中的jst版本修改即可<br>
				如果出现提示"Project Facets"或者是jre版本不对的话，应该看看是否在pom中加入了maven-compiler-plugin<br>
			</li>
		</ul>

		<h4>JFinal的数据库插件配置</h4>
		<ul>
			<li><strong>描述：</strong> configPlugin中配置数据库插件</li>
			<li><strong>解决：</strong> 常用插件有C3p0Plugin和DruidPlugin<br>
				虽然JFinal中含有相关的C3p0和druid的包，但是还是要单独引入C3p0等包，因为JFinal中的不完整<br>
			</li>
		</ul>

		<h4>mvn jetty:run提示缺少jetty配置</h4>
		<ul>
			<li><strong>描述：</strong> mvn jetty:run提示缺少jetty配置</li>
			<li><strong>解决：</strong> 在pom.xml中，配置maven-compiler-plugin才能正常调用jetty
			</li>
		</ul>
		
		<h4>jetty启动提示ActiveRecordPlugin启动失败</h4>
		<ul>
			<li><strong>描述：</strong> jetty启动提示ActiveRecordPlugin启动失败</li>
			<li><strong>解决：</strong> 数据库必须建立相应的数据表
			</li>
		</ul>
		
		<h4>jsp使用\${initParam.base}与\${initParam.resources}代替项目路径</h4>
		<ul>
			<li><strong>描述：</strong> 更改项目名称时会导致所有的前端中的项目路径都需要修改</li>
			<li><strong>解决：</strong> 在web.xml中使用上下文参数配置context-param<br>
			常用\${initParam.base}配置路由（如表单、链接），\${initParam.resources}配置js、css等资源引入。
			</li>
		</ul>
		
	</div>
	
	<%@ include file='/WEB-INF/commonpages/common.jsp'%>
</body>
</html>