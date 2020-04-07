<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 서버에서 응답하는 Response 객체 -->
	<p>First Page!!</p>
	
	<!-- 응답을 secondPag.jsp로 전달하여 secondPage.jsp가 열리게 된다.  -->
	<%
		response.sendRedirect("secondPage.jsp");
	%>
	
</body>
</html>