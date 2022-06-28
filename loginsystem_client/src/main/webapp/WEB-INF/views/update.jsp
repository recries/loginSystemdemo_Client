<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<form name="frm" action="update.do" method="post">
	
	<input type="hidden" name="user_num" value="${dto.user_num }">
	
	<p><input type="text" name="id" placeholder="${dto.id}"></p>
	
	<p><input type="text" name="pass" placeholder="${dto.pass}"></p>
	
	<p><input type="text" name="name" placeholder="${dto.name}"></p>
	
	<p><input type="text" name="email" placeholder="${dto.email}"></p>
	
	<p><input type="submit" value="send"></p>
	
	</form>
</body>
</html>