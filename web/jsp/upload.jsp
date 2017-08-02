<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="uploadServlet" method="post" enctype="multipart/form-data">
		
		File: <input type="file" name="file"/>
		<br>
		<br>
		Desc: <input type="text" name="desc"/>
		<br>
		<br>
		
		<input type="checkbox" name="interesting" value="Reading"/>Reading
		<input type="checkbox" name="interesting" value="Party"/>Party
		<input type="checkbox" name="interesting" value="Sports"/>Sports
		<input type="checkbox" name="interesting" value="Shopping"/>Shopping
		<br>
		<br>
		
		
		<input type="submit" value="Submit"/>
		
	</form>
	
</body>
</html>