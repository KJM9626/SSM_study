<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><fmt:message key="welcomeinfo"/></h1>
<form action="" >
<fmt:message key="username"></fmt:message>:<input /><br>
<fmt:message key="password"></fmt:message>:<input /><br>
<input type="submit" value='<fmt:message key="loginBtn"></fmt:message>'/><br>
<!-- 点击链接切换国际化 -->
<a href="loginTest?locale=zh_CN">中文</a>
<a href="loginTest?locale=en_US">English</a>
</form>
</body>
</html>