<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tomcat.apache.org/jsp2-example-taglib" prefix="myFt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/registerServlet" method="post">
姓名：<input type="text" name="name"/><br>
年龄：<input type="text" name="age"/><br>
<input type="submit" value="注册">
</form>

${myFt:myLTU("abc")}<br>
本机IP地址=<myFt:clientIp/>
<br>
<%
String str="helloworld";
session.setAttribute("str",str);

boolean gender=true;
session.setAttribute("gender",gender);

List<String> list=new ArrayList<>();
list.add("中国");
list.add("美国");
list.add("德国");
pageContext.setAttribute("list", list);

Set set=new HashSet();
set.add("jack");
set.add("joe");
set.add("hello");
pageContext.setAttribute("set", set);

double[] nums={14.1,34.2,25.3};
pageContext.setAttribute("nums", nums);
%>
str的内容=<myFt:myLtU>${str }</myFt:myLtU><br>
<myFt:ifTag test="${gender }">我爱你</myFt:ifTag>
<myFt:ifTag test="${not gender }">我不爱你</myFt:ifTag>

<myFt:forEach items="${list }" var="name">
${name }<br>
</myFt:forEach>

<myFt:forEach items="${set }" var="sss">
${sss }<br>
</myFt:forEach>

<myFt:forEach items="${nums}" var="num">
${num }
</myFt:forEach>
</body>
</html>