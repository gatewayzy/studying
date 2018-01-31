<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${initParam.resources}/static/lib/css/pagination.css">
<link rel="stylesheet" type="text/css"
	href="${initParam.resources}/static/css/commonpages/common.css">
<title>label</title>
<style type="text/css">
a {
	color: red
}
</style>
</head>
<body>
	<h3>标签总数：34780条</h3>
	<div style="width: 50%; margin: 5px auto 15px 0px">
		<div>
			<span id="getTag" tagId="${tag.tagId}"> 当前标签： <b>${tag.tagName}|${tag.tagId}</b>
				<a href="http://baike.baidu.com/item/${tag.tagName}" target="_blank">百度查询</a>
				<a
				href="http://zcy.ckcest.cn/tcm/gatherinfo?query=${tag.tagName}#basic_knowledge"
				target="_blank">tcm查询</a>

			</span>
		</div>
		<div>
			<span> <input type="text" id="goto">
			</span> <a href="#" onclick="return gotoTag()">跳到id</a>&nbsp; <a href="#"
				onclick="return save(0)">上一个</a>&nbsp; <a href="#"
				onclick="return save(-1)">跳过</a>&nbsp;
		</div>
	</div>
	<table style="display: inline-block;" id="result1" border="1">
		<c:forEach var="cate" items="${cates1}">
			<tr>
				<td>${cate.id}</td>
				<td>${cate.cate1}</td>
				<td><a href="#" onclick="return save(${cate.id})">${cate.cate2}</a></td>
			</tr>
		</c:forEach>
	</table>
	<table style="display: inline-block;" id="result2" border="1">
		<c:forEach var="cate" items="${cates2}">
			<tr>
				<td>${cate.id}</td>
				<td>${cate.cate1}</td>
				<td><a href="#" onclick="return save(${cate.id})">${cate.cate2}</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>

</body>

<script type="text/javascript" language="javascript"
	src="${initParam.resources}/static/lib/js/jquery.min.js"></script>
<script type="text/javascript" language="javascript"
	src="${initParam.resources}/static/lib/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" language="javascript"
	src="${initParam.resources}/static/lib/js/jquery.pagination.js"></script>
<script type="text/javascript">
	function gotoTag(){
		var tagId = $("#goto").val();
		save(-1,tagId-1)
	}
	function save(cateId,tagId) {
		if(tagId == undefined){
		 tagId = $("#getTag").attr("tagId")
		}
		$.ajax({
			type : "POST",
			url : "./saveLabel",
			data : {
				"tagId" : tagId,
				"cateId":cateId
			},
			dataType : "json",
			success :saveOk
		})
		return false;
	}
	function saveOk(data){
		var data = data.ret
		var tagId = data.tagId
		$("#getTag").attr("tagId", tagId)
		var str = "标签： <b>"+ data.tagName +"|</b>"+data.tagId+"&nbsp;&nbsp;&nbsp;&nbsp;<a href='http://baike.baidu.com/item/"+data.tagName+"' target='_blank'>百度查询</a>&nbsp;&nbsp;&nbsp;&nbsp;"+
			"<a href='http://zcy.ckcest.cn/tcm/gatherinfo?query="+data.tagName+"#basic_knowledge' target='_blank'>tcm查询</a>"
		$("#getTag").html(str)
		return false;
	}
</script>

</html>