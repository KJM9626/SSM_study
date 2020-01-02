<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
恭喜成功跳转页面！
<br>
<%System.out.println("测试拦截器成功"); %>
<br>
request:${requestScope.requestArgs }<br>
session:${sessionScope.sessionArgs }<br>

获取map中保存的数据:${requestScope.mapParam }<br>
获取model中保存的数据:${requestScope.modelParam }<br>
获取modelMap中保存的数据:${requestScope.modelMapParam }<br>
获取modelAndView中保存的数据:${requestScope.msg }<br>
通过session域中获取modelAndView中保存的数据:${sessionScope.msg }<br>
</body>
</html>