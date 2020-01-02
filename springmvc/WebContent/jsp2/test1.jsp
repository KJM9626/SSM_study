<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
test1.jsp page before<br>
<jsp:include page="/jsp2/test2.jsp"/><br>
test1.jsp page after<br>
<!-- 这是一种动态联编，不可以实现调用其他页面的值 -->
<%String str="woaini"; %>
str=<%=str %>
</body>
</html>