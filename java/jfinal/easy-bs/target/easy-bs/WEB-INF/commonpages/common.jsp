<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${initParam.resources}/static/css/commonpages/common.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="fixed_top">
		<ul>
			<li><a href="${initParam.base}">项目首页</a></li>
			<li><a href="${initParam.base}/index/login">登录页面--</a></li>
			<li><a href="${initParam.base}/actionKey">班级数据--数据库的CRUD操作，采用/actionKey路由</a></li>
			<li><a href="${initParam.base}/classes">班级数据--页面分页，页面全刷新</a></li>
			<li><a href="${initParam.base}/classes?isAjax= true">班级数据--页面分页，ajax获取</a></li>
			<li><a href="${initParam.base}/student">学生数据--暂无服务</a></li>
		</ul>
	</div>
</body>
</html>