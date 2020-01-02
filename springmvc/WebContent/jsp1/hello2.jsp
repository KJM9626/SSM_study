<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date,java.text.*" %>
    <%@ page isErrorPage="true" %>
    <%-- 也可以使用这种用法<%@ page import="java.util.*"  %>--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
hello2页面
<br/>
<% 
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date now=new Date();
out.println("现在的时间是："+sdf.format(now));
%>
<br>
<%String str=(String)session.getAttribute("aaa"); 
int m=6;
out.println("m="+m);
%>
<br>
str=<%=str %>
</body>
</html>