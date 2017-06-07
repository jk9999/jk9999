<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><!-- 시험 문제 EL 문 -->
	<table align="center"> 
		<caption>고객 정보</caption>
		<tr><td>이 름</td><td>${employee.empno}</td></tr>
		<tr><td>비 번</td><td>${employee.ename}  </td></tr>
		<tr><td>아이디</td><td>${employee.salary}</td></tr>
		<tr><td>이메일</td><td>${employee.position}</td></tr>
		<tr><td>주  소</td><td>${employee.address}</td></tr>
	</table>
</body>
</html>






