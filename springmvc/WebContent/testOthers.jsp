<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%pageContext.setAttribute("ctp",request.getContextPath()); %>
</head>
<body>
${msg }
<form action="${ctp }/simpleUpload" method="post" enctype="multipart/form-data">
用户名：<input type="text" name="username" /><br>
密码：<input name="password" type="text"/><br>
文件上传：<input type="file" name="file"/><br>
<input type="submit" value="提交"/>

</form>

${multimsg }
<form action="${ctp }/multiUpload" method="post" enctype="multipart/form-data">
用户名：<input type="text" name="username"/>
文件上传：<input type="file" name="file" multiple="multiple"/>
<input type="submit" value="提交"/>
</form>

<a href="${ctp }/testHandlerInterceptor">测试拦截器</a>
</body>
</html>