<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工列表页面</title>
<%pageContext.setAttribute("ctp", request.getContextPath()); %>
<script type="text/javascript" src="${ctp }/script/jquery-1.7.2.min.js"></script>
</head>
<body>
<h1>员工列表</h1>
<table border="1" cellpadding="5" cellspacing="0">
<tr>
<td>id</td>
<td>lastName</td>
<td>email</td>
<td>gender</td>
<td>birth</td>
<td>departmentName</td>
<td>edit</td>
<td>delete</td>
</tr>
<c:forEach items="${emps }" var="emp">
<tr>
<td>${emp.id }</td>
<td>${emp.lastName }</td>
<td>${emp.email }</td>
<td>${emp.gender==1?"男":"女" }</td>
<td>${emp.birth }</td>
<td>${emp.department.departmentName }</td>
<td>
<a href="${ctp }/emp/${emp.id}">edit</a>
</td>
<td>
<a href="${ctp }/emp/${emp.id}" class="delBtn">delete</a>
</td>
</tr>
</c:forEach>
</table>
<a href="${ctp }/toAddPage">添加页面</a>

<form id="deleteForm" action="${ctp }/emp/${emp.id}" method="post">
<input type="hidden" name="_method" value="delete" />
</form>
<script type="text/javascript">
$(function () {
	$(".delBtn").click(function(){
		//改变表单的action指向
		$("#deleteForm").attr("action",this.href);
		//提交表单
		$("#deleteForm").submit();
		return false;
	});
});
</script>

<form action="${ctp }/quickAdd">
<input type="text" name="empinfo" value="empAdmin-admin@qq.com-1-101"/>
<input type="submit" value="快速添加"/>
</form>
</body>
</html>