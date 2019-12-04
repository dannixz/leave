<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
div {
	width: 700px;
	margin: auto;
}
h2,p{
text-align: center;
}
</style>
</head>
<body>
	<div>
	<h2>添加请假记录</h2>
	<form action="AddServlet" method="post">
		<table>
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td>请假时间：</td>
				<td><input type="text" name="time" id="time">格式要求：yyyy-mm-dd</td>
				
			</tr>
			<tr>
				<td>请假原因：</td>
				<td><textarea rows="7" cols="60" id="reason" name="reason">
</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交"> <input
					type="reset" value="清空"></td>
			</tr>
		</table>
	</form>
	</div>
<script type="text/javascript" src="js/jquery-1.12.3.js"></script>
<script type="text/javascript">
$("form").submit(function() {
	var name =$("#name").val();
	var time= $("#time").val();
	var reason = $("#reason").val();
	if (name== null || name=="" || time==null || time=="" || reason==null || reason=="") {
		alert("信息未填写完整，请完善");
		return false;
	}
	return true;
})
</script>
</body>
</html>