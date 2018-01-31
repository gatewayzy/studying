<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${initParam.resources}/static/css/commonpages/common.css">
<script type="text/javascript">
	function check(obj){
		var id = document.getElementById("id");
		var claID = id.value;
		if(claID == "" || claID == undefined){
			alert("请输入要"+obj.innerText+"的claID，请在输入claID之后再次操作");
			return false;
		}
		else{
			obj.href += "?claID=" + claID;
			return true;
		}
	}
	
	function showadd(){
		var add_div = document.getElementById("add_div");
		add_div.style.display = "block";
		return false;
	}
</script>
<title>classes-home</title>
</head>
<body>

	<div style="width:50%; margin: 5px auto 15px 0px">
		<ul>
			<li>添加--页面直接显示隐藏的添加框，未使用ajax</li>
			<li>查看，修改和删除都需要先填写claId</li>
		</ul>
	</div>
	
	<div id="add_div" style="display: none">
		<form action="${initParam.base}/classes/doadd">
			<input type="text" name="claID" placeholder="claID"> 
			<input type="text" name="claName" placeholder="名称"> 
			<input type="text" name="claCharger" placeholder="负责人">
			<input type="text" name="claPeople" placeholder="人数">
			<input type="submit" value="添加">
		</form>
	</div>
	<br>
	<table border="1">
		<tr>
			<td>claID</td>
			<td>班级名称</td>
			<td>负责人</td>
			<td>班级人数</td>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.claID}</td>
				<td>${list.claName}</td>
				<td>${list.claCharger}</td>
				<td>${list.claPeople}</td>
			</tr>
		</c:forEach>
	</table>
	<div class="fixed_right">
		<ul class="">
			<li><a href="${initParam.base}/classes/add"
				onclick="return showadd()">添加</a></li>
			<li><input type="text" id="id" placeholder="claID"></li>
			<li><a href="${initParam.base}/classes/detail"
				onclick="return check(this)">查看</a></li>
			<li><a href="#">修改(在'查看'页面修改)</a></li>
			<li><a href="${initParam.base}/classes/delete/"
				onclick="return check(this)">删除</a></li>
			<li>这里用js检查claID<br>并对URL添加参数../?claID=1&...</li>
		</ul>
	</div>
	
	<%@ include file='/WEB-INF/commonpages/common.jsp'%>
</body>
</html>