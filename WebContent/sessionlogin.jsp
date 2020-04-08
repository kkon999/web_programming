<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 기존에 사용자가 세션 유무 여부 확인 -->
	<!-- memberId가 null이 아니면 loginOk.jsp로 이동-->
	<%
		if(session.getAttribute("memberId") !=null)
			response.sendRedirect("SessionloginOk.jsp");
	%>
	
	<!-- 사용자 로그인 작성 form -->
	<form action ="sessionloginCon" method = "post">
		ID : <input type = "text"     name = "mID"><br>
		PW : <input type = "password" name = "mPW"><br> 
		<input type = "submit" value = "login">	
	
	</form>
</body>
</html>