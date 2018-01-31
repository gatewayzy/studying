<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${initParam.resources}/static/css/commonpages/common.css">
<script type="text/javascript">
	function changepage(obj) {
		var pageNumber = ${pageNumber};
		var totalpage = ${totalpage};
		if (obj.innerText == "下一页") {
			if (pageNumber == totalpage) {
				alert("已经是最后一页");
				return false;
			}
			pageNumber++;
		} else {
			if (pageNumber == 1) {
				alert("没有上一页");
				return false;
			}
			pageNumber--;
		}
		window.location.href = "${initParam.base}/classes?pageNumber="
				+ (pageNumber);
		return false;
	}
</script>

<title>非ajax与数据分页--classes</title>
</head>
<body>

	<div style="width:50%; margin: 5px auto 15px 0px">
		使用ajax与不使用ajax，只存在页面渲染上的区别，使用ajax可以减少页面渲染的资源消耗，但是无法改变后台在获取相应分页的数据所用的消耗。
	</div>

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
	<br>
	<a href="#" onclick="return changepage(this);" name="上一页">上一页</a>
	<a href="#" onclick="return changepage(this);" name="下一页">下一页</a>
	<br>
	第${pageNumber}页/共${totalpage}页，每页${pageSize}条/共${totalRow}条。
	
	<%@ include file='/WEB-INF/commonpages/common.jsp'%>
</body>
</html>