<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 로그인 후 저장된 세션을 출력 -->
	<%
		session = request.getSession();
		out.print("memberId : " + session.getAttribute("memberId")+"<br>");
	%>
	
	<!-- 로그아웃 기능 생성 -->
	<form action = "sessionlogout" method="post">
		<input type=  "submit" value = "logout">
	</form>
</body>
</html>