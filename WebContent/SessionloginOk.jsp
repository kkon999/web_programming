<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<!-- �α��� �� ����� ������ ��� -->
	<%
		session = request.getSession();
		out.print("memberId : " + session.getAttribute("memberId")+"<br>");
	%>
	
	<!-- �α׾ƿ� ��� ���� -->
	<form action = "sessionlogout" method="post">
		<input type=  "submit" value = "logout">
	</form>
</body>
</html>