<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% 
		//1. 通知客户端浏览器: 这是一个需要下载的文件, 不能再按普通的 html 的方式打开.
		//即设置一个响应的类型: application/x-msdownload
		response.setContentType("application/x-msdownload"); 
	
		//2. 通知客户端浏览器: 不再有浏览器来处理该文件, 而是交由用户自行处理
		//设置用户处理的方式: 响应头: Content-Disposition
		response.setHeader("Content-Disposition", "attachment;filename=abc.txt");
	%>
	
	<h4>Test Page</h4>
	
	Time: <%= new Date() %>
	
</body>
</html>