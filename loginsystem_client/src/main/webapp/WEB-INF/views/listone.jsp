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
<div id="wrap">
<table>

<tr>
<th>id</th><th>pass</th><th>name</th><th>email</th><th>user_num</th>
</tr>

<tr>
<th>${dto.id}</th><th>${dto.pass}</th><th>${dto.name}</th><th>${dto.email}</th><th>${dto.user_num}</th>
</tr>

</table>
</div>
</body>
</html>