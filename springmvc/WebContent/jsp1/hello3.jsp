<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/jsp1/error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <% 
out.println("3/0="+3/0);
%> --%>
helloworld
<%@ include file="/jsp1/hello.jsp" %>
<%out.println(str); %><br>
hellokitty
</body>
</html>