<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.springmvc.demo.School"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.springmvc.demo.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
test2.jsp页面<br>
<%
String str="helloworld";
session.setAttribute("aaa","1");
pageContext.setAttribute("aaa","2");
application.setAttribute("aaa","3");
request.setAttribute("aaa",str);

School sch=new School("合肥工业大学","合肥市蜀山区");
Student stu=new Student("jack",17,sch);
request.setAttribute("stu",stu);
String names[]={"清华","北大","南开","中大"};
session.setAttribute("names", names);

List<String> list=new ArrayList<>();
list.add("中国");
list.add("美国");
list.add("德国");
session.setAttribute("list", list);

Map<String,Object> map=new HashMap<>();
map.put("school", sch);
map.put("num", 123445);
map.put("name", "中国");
pageContext.setAttribute("map", map);
%>
aaa=${requestScope.aaa}<br>
name=${stu.getName()}<br>
<!-- 另一种写法 -->
age=${stu['age'] }<br>
<!-- 若访问为null的对象的属性，EL是不会抛出空指针异常，其仅仅是不显示而已 -->
name5=${stuent5.name}<br>
info=${stu.getSchool().getSname()}<br>
names[1]=${names[1] }<br>
list[1]=${list[1] }<br>
school.sname=${map.school.sname }<br>
num=${map.num }<br>

</body>
</html>