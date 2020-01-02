<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.springmvc.demo.School"%>
    <%@ page import="java.util.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl标签库</title>
</head>
<body>
<!-- c:set使用 -->
<c:set var="name" value="helloworld"/>
name=${name }
<br>
<% School school=new School();request.setAttribute("school",school); %>
<c:set property="sname" value="清华大学" target="${requestScope.school }"></c:set>
<c:set property="address" value="北京海淀区" target="${requestScope.school }"></c:set>
大学名字是=${school.sname }
地址是=${school.address }
<br>
<!-- c:catch使用 -->
<c:catch var="ex">
<%int i=3/0; %>
</c:catch>
错误信息为:${ex.message }
<br>
<c:set var="pageno" value="1"></c:set>
<c:set var="totalPage" value="3"></c:set>
<c:choose>
<c:when test="${pageno==1}">
首页  第一页  <a href="#">下一页</a> <a href="#">末页</a> 当前第${pageno }页/共${totalPage }页
</c:when>
<c:when test="${pageno==totalPage}">
<a href="#">首页</a>  <a href="#">第一页</a>  下一页 末页 当前第${pageno }页/共${totalPage }页
</c:when>
<c:otherwise>
<a href="#">首页</a>  <a href="#">第一页</a>  <a href="#">下一页</a> <a href="#">末页</a>  当前第${pageno }页/共${totalPage }页
</c:otherwise>
</c:choose>
<br>
<!-- 格式化日期 -->
<%
Date now=new Date();
pageContext.setAttribute("now",now);
%>
now=<fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss" var="birth"/><br>
生日:<input type="text" name="birthday" value="${birth }">

</body>
</html>