<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请假记录列表</title>
<style type="text/css">
div,table {
	width: 500px;
	margin: auto;
}
h2,p,table{
text-align: center;
}
</style>
</head>
<body>
<c:if test="${empty page.list}">
<c:redirect url="ShowServlet">
</c:redirect>
</c:if>
	<div>
			<h2>请假记录列表</h2>
			<a href="addLeave.jsp">添加请假记录</a>
			<table border="1">
				<tr>
					<th>编号</th>
					<th>姓名</th>
					<th>请假时间</th>
					<th>请假原因</th>
					<th>操作</th>
				</tr>
				<c:forEach var="ct" items="${page.list}">
				<tr>
					<td>${ct.id}</td>
					<td>${ct.name}</td>
					<td>${ct.leaveTime}</td>
					<td>${ct.reason}</td>
					<td><a href="#" onclick="Del('${ct.id}')">删除</a></td>
				</tr>
				</c:forEach>
			</table>
			<p><a href="ShowServlet?pageNum=1">首页</a>
			<a href="ShowServlet?pageNum=${page.danqianye-1<0 ? page.danqianye:page.danqianye-1}">上一页</a>
			<a href="ShowServlet?pageNum=${page.danqianye+1>page.zongyeshu ?page.danqianye:page.danqianye+1 }">下一页</a>
			<a href="ShowServlet?pageNum=1">末页</a>
			<a>第${page.danqianye}页/共${page.zongyeshu}页</a><p>
	</div>
<script type="text/javascript" src="js/jquery-1.12.3.js"></script>
<script type="text/javascript">

$("tr:even").css("background-color","yellow");
function Del(id) {
	if (confirm('确定删除吗？')) {
		
		$.ajax({
			url : "DelServlet",
			type : "post",
			data : "id="+id,
			dataType : "text",
			success : callBack,
			error : function() {
				alert("出现异常");
			}
		});
		function callBack(data) {
			
			if (data > 0) {
				alert("删除成功");
				location.reload();
			}else{
				alert("删除失败");
			}
		}
	}
}
</script>
</body>
</html>