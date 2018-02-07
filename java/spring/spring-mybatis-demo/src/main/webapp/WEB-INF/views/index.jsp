<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<html>
<body>
<h2>Hello World!</h2>
<h3>网站地图：</h3>
<ol>
    <li><a href="${initParam.base}/">首页，全局拦截</a></li>
    <li><a href="${initParam.base}/data/user">查看用户，应该被data拦截</a></li>
    <li><a href="${initParam.base}/data/role">查看角色，不会被data拦截</a></li>
</ol>
<h3>数据显示：</h3>
<ul>
    <li>${user.id}</li>
    <li>${user.name}</li>
    <li>${role.id}</li>
    <li>${role.name}</li>
</ul>
</body>
</html>
