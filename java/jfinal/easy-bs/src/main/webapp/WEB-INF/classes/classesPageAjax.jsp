<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${initParam.resources}/static/lib/css/pagination.css">
<title>ajax与数据分页--classes</title>
</head>
<body>
	<div style="width: 50%; margin: 5px auto 15px 0px">
		本页采用jQuery Pagination分页插件，支持自定义css。参考链接：<a target="_blank"
			href="http://www.zhangxinxu.com/jq/pagination_zh/">点击这里</a>
	</div>
	<table id="result" border="1">
	</table>
	<br>

	<div id="panel" class="pagination"></div>

	<%@ include file='/WEB-INF/commonpages/common.jsp'%>
</body>

<script type="text/javascript" language="javascript"
	src="${initParam.resources}/static/lib/js/jquery.min.js"></script>
<script type="text/javascript" language="javascript"
	src="${initParam.resources}/static/lib/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" language="javascript"
	src="${initParam.resources}/static/lib/js/jquery.pagination.js"></script>
<script type="text/javascript">
	function pageselectCallback(page) {
		$
				.ajax({
					type : "post",
					dataType : "json",
					url : "classes/pageAjax", //请求的url 
					data : {
						"pageNumber" : parseInt(page + 1)
					},
					success : function(data) {
						var result = "<tr><td>claID</td><td>班级名称</td><td>负责人</td><td>班级人数</td></tr>";
						$.each(data.list, function(i, ite) {
							var tmp = "";
							tmp += "<tr><td>" + ite.claID;
							tmp += "</td><td>" + ite.claName;
							tmp += "</td><td>" + ite.claCharger;
							tmp += "</td><td>" + ite.claPeople + "</td></tr>";
							result += tmp;
						})
						$("#result").html(result);
					},
					error : function(textStatus) {
						alert("error!要查询数据超出范围");
						console.info(msg);
					}
				});
	}
	$(document).ready(function() {
		var maxentries = ${totalpage}; //总页面数
		$("#panel").pagination(maxentries, { //此方法一次性加载，分页切换无刷新与延迟
			num_edge_entries : 2, //首尾两侧分页显示页数
			num_display_entries : 4, //连续分页主体数目显示页数
			callback : pageselectCallback,//回调函数
			current_page : 0, // 初始化页数为第current_page+1页
			items_per_page : 1, //每页显示页数
			prev_text : "上一页",
			next_text : "下一页",
			ellipse_text : "..", //省略的页数用什么文字表示
			prev_show_always : false,//总是显示“上一页”链接
			next_show_always : false,
		});

	});
</script>

</html>