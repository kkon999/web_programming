<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<!-- ���� ���� -->
	<!-- applicationEx�� ������ application ��ü�� ���� ���� -->
	<%!
	 	String connectedIP;
	 	String connectedUser;
	%>
	
	<!-- application ��ü -->
	<!-- getAttribute�� �Ͽ� �����͸� ȣ���� �� (String)����ȯ�� ���ؼ� ȣ�� -->
	<%
		connectedIP = (String)application.getAttribute("connectedIP");
		connectedUser = (String)application.getAttribute("connectedUser");
	%>
	
	<!-- HTML�� ǥ�� -->
	<p>connectedIP : <%= connectedIP%></p>
	<p>connectedUser : <%= connectedUser%></p>
	
</body>
</html>