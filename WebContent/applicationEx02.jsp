<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 변수 선언 -->
	<!-- applicationEx에 설정한 application 객체를 변수 선언 -->
	<%!
	 	String connectedIP;
	 	String connectedUser;
	%>
	
	<!-- application 객체 -->
	<!-- getAttribute를 하여 데이터를 호출할 때 (String)형변환을 통해서 호출 -->
	<%
		connectedIP = (String)application.getAttribute("connectedIP");
		connectedUser = (String)application.getAttribute("connectedUser");
	%>
	
	<!-- HTML에 표시 -->
	<p>connectedIP : <%= connectedIP%></p>
	<p>connectedUser : <%= connectedUser%></p>
	
</body>
</html>