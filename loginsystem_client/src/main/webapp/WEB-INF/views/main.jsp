<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body>
<div id="wrap">
<a href="write.do">회원가입</a>
<table>
<tr>
<th>user_num</th><th>id</th><th>수정</th><th>삭제</th>
</tr>
<c:forEach items="${aList}" var="dto">
<tr>
<td>${dto.user_num }</td><td>${dto.id }</td>
<td>
<form action="update.do">
	<input type="hidden" name="user_num" value="${dto.user_num }"/>
	<input type="hidden" name="id" value="${dto.id}"/>
	<input type="hidden" name="pass" value="${dto.pass}"/>
	<input type="hidden" name="name" value="${dto.name}"/>
	<input type="hidden" name="email" value="${dto.email}"/>
	<input type="submit" value="수정"/>
</form>
</td>
<td>
<form action="delete.do">
	<input type="hidden" name="user_num" value="${dto.user_num}"/>
	<input type="submit" value='삭제'/>
</form>
</td>
</tr>
</c:forEach>
</table>

</div>
</body>
</html>