<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
public void say(String str){
	System.out.println("str的内容是："+str);
}
private int i=10;
%>
<html>
<%int j=3; %>
<head>
<meta charset="UTF-8">
<%double count=3.4; %>
<title>springmvc</title>
</head>
<body>
hello jsp!
<br/>
count=<%=count %>
<%double sum=count*(i+j); 
//java代码块中是不能写方法，也不能写静态代码块
%>
<%-- --%>

</body>
</html>
<%
String data="我是中国人";
System.out.println("sum="+sum);
say(data);
%>