<%@page import="com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlPartitioningDef.Values"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function doedit(){
		var claID = document.getElementById("claID").value;
		var claName = document.getElementById("claName").value;
		var claCharger = document.getElementById("claCharger").value;
		var claPeople = document.getElementById("claPeople").value;
		window.location.href="${initParam.base}/classes/edit/?claName="+
				claName+"&claCharger="+claCharger+"&claPeople="+claPeople+"&claID="+claID;
	}
</script>
<title>detail</title>
</head>
<body>
	<div>
		班级ID：<input type="text" value="${classes.claID}" name="claID" id="claID">
		班级名称：<input type="text" value="${classes.claName}" name="claName" id="claName">
		班主任：<input type="text" value="${classes.claCharger}" name="claCharger" id="claCharger">
		班级人数：<input type="text" value="${classes.claPeople}" name="claPeople" id="claPeople">
		<input type="button" value="保存" onclick="doedit()">
	</div>
	不同的后台获取方式获取的结果相同
	${classes.claCharger}<br>
	${classes.claPeople}<br>
	${claCharger}<br>
	${claPeople}<br>
	${classes3.claCharger}<br>
	${classes3.claPeople}<br>
	
	<%@ include file='/WEB-INF/commonpages/common.jsp'%>
</body>
</html>