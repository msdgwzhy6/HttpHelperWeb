<%--
  Created by IntelliJ IDEA.
  User: smart
  Date: 2017/8/1
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Insert title here</title>
</head>
<body background="img/background.jpg">
<form action="/register" method="get">
  name：<input type="text" name="name"><br>
  age：  <input type="text" name="age"><br>
  submit:<input type="submit" value="submit"><br>
</form>
<a href="jsp/upload.jsp">文件的上传</a>
<br>
<br>

<a href="jsp/file/download.jsp">文件的下载</a>
</body>
</html>
