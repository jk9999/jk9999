<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
<link href="../css/basic.css" rel="stylesheet" type="text/css">
</head>
<body>
<form method="post" action="insertEmployee.do" >
<table  align='center' >
	<tr><td class="caption" colspan='2'>회원가입</td></tr>
	<tr><td class='tbasic'>회원번호</td>
	    <td class='tbasic'><input type='text' name='empno'  id='empno' value='${employee.empno}'></td>
	</tr>
	<tr><td class='tbasic'>이 &nbsp;름</td>
	    <td class='tbasic'><input type='text' name='ename'  id='ename' value='${employee.ename}'></td>
	</tr>
	<tr><td class='tbasic'>월급</td>
	    <td class='tbasic'><input type='text' name='salary'  id='salary' value='${employee.salary}'>
	</tr>
	<tr><td class='tbasic'>직 &nbsp;위</td>
	    <td class='tbasic'><input type='text' name='position'  id='position' value='${employee.position}'>
	</tr>
	<tr><td class='tbasic'>주소</td>
	    <td class='tbasic'><input type='text' name='address'  id='address' value='${employee.address}'></td>
	</tr>
	<tr>
	   <td colspan='2' align='center' class='tfoot tspacial'>
	     <input type="submit" value='전송'>
		 <input type="reset" value='취소'>
	   </td>
	</tr>
</table>
</form>
</body>
</html>






