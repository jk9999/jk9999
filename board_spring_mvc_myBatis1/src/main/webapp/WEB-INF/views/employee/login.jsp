<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
 	<% String empno = (String) session.getAttribute("id");
 	if(empno ==null){    //�α��� ���� ���� ���   �α��� ȭ�� ���
 	  Cookie[] cookies = request.getCookies();
 		String idSave ="";
 	    for(Cookie cookie: cookies){
 	    	if(cookie.getName().equals("idsave")){
 	    		idSave = cookie.getValue();
 	    	}
 	    }
 	    String msg = (String)request.getAttribute("msg");
 	    if(msg!=null && !msg.equals("")){ %>
 	    <p  style="color:red"><%=msg %></p>
 	 <% } %>
	<form action="login.do" method="post"  id="frm">
		�� �� ��: <input type="text" name="empno" value='<%=idSave %>'  id="empno"/><br/>
		<input type="checkbox" name='idsave' value='t'
		 <%= idSave.length()>0? "checked='checked'" :"" %>
		>���̵� ����
		<input type="submit" value="����"/>
	</form>
	<%} %>
</body>
</html>















