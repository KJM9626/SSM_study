<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>springmvc</title>
</head>
<body>
<a href="hello/world">helloworld</a>
<br>
<a href="hello/user/admin">测试pathvaribale风格</a><br>
<!-- 使用REST风格进行图书的增删改查 -->
<a href="book/1">查询图书</a><br>
<form action="book/1" method="post">
<input name="_method" value="delete"/>
<input type="submit" value="删除图书"/>
</form><br>
<form action="book/1" method="post">
<input name="_method" value="put"/>
<input type="submit" value="更新图书"/>
</form><br>
<form action="book" method="post">
<input type="submit" value="添加图书"/>
</form><br>

<a href="hello/username?username=jack">获取username的值</a>

<form action="hello/book">
bookName:<input type="text" name="bookName"></input><br>
author:<input type="text" name="author"></input><br>
price:<input type="text" name="price"></input><br>
sales:<input type="text" name="sales"></input><br>
type:<input type="text" name="type"></input><br>
<hr>
province:<input type="text" name="address.province"/><br>
city:<input type="text" name="address.city"/><br>
<input type="submit">
</form>

<br>
<a href="hello/nativeapi">获取request与session的参数</a>
<br>
<a href="hello/map">输出map中传入的参数</a><br>
<a href="hello/model">输出model中传入的参数</a><br>
<a href="hello/modelMap">输出modelMap中传入的参数</a><br>

<a href="hello/modelAndView">输出modelAndView中传入的参数</a><br>

<a href="hello/test">去到特定页面</a>

<a href="hello/loginTest">验证国际化信息</a><br>

<a href="handle">下载视频与图片资源</a><br>

<a href="hello/exTest?i=10">测试异常信息</a>
</body>
</html>
