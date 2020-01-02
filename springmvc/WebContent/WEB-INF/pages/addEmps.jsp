<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工添加页面</title>
 <%pageContext.setAttribute("ctp",request.getContextPath()); %>
</head>
<body>
<h1>员工添加</h1>
<!-- 表单标签：通过springmvc的表单可以实现将模型数据中的属性和HTML表单元素相绑定，以实现表单数据更便捷编辑和表单值的回显标签
springmvc认为，表单数据中的每一项最终都是要回显的；path指定的是一个属性，这个属性是从隐含模型（请求域中取出的某个对象中的属性）；path指定的每一个属性，请求域中必须有一个对象，拥有这个属性，这个对象就是请求域中的command
 modelAttribute="";1.以前我们表单标签会从请求域中获取一个command对象，把这个对象中的每一个属性对象的显示出来 2.现在可以告诉springmvc不要去取command的值了，我放了一个modelAttribute指定的值，取对象用的key就用我modelAttribute指定的就可以了
 -->
<form:form action="${ctp }/emp" modelAttribute="employee" method="post">
<!-- path就是原来的html-input的name选项，而且path有两层作用：当做原生的name项；自动回显隐含模型中某个对象对应的这个属性的值 -->
lastName:<form:input path="lastName"/>
<form:errors path="lastName"/>-->${errorInfo.lastName }<br>
email:<form:input path="email"/>
<form:errors path="email"/>-->${errorInfo.email }<br>
gender:&nbsp;&nbsp;&nbsp;
男:<form:radiobutton path="gender" value="1"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
女:<form:radiobutton path="gender" value="0"/><br>
birth:<form:input path="birth"/>
<form:errors path="birth"/>-->${errorInfo.birth }<br>
<!-- item指定要遍历的集合自动遍历，遍历出的每一个元素是一个department对象
itemLabel=“属性名”，指定遍历出的这个对象的那个属性是作为optiona提交标签体的值
itemValue=“属性名”，指定刚才遍历出来的这个对象的那个属性是作为要提交的value值 -->
dept:<form:select path="department.id" items="${deps }" itemLabel="departmentName" itemValue="id">
</form:select><br>
<input type="submit" value="提交"/>
</form:form>
<!-- <form action="WEB-INF/pages/list.jsp" method="post">
lastName:<input type="text" name="lastName"/><br>
email:<input type="text" name="email"/><br>
gender:<br>
男:<input type="radio" name="gender" value="1"/><br>
女:<input type="radio" name="gender" value="0"/><br>
dept:
<select name="department.id">
<c:forEach items="${deps }" var="dept">
<!-- 标签体中的是在页面的提示选项信息，value才是真正要提交的值 --
<option value="${dept.id }">${dept.departmentName }</option>
</c:forEach>
</select>
<input type="submit" value="提交"/>

</form> -->
</body>
</html>