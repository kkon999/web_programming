<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<!-- �������� �����ϴ� Response ��ü -->
	<p>First Page!!</p>
	
	<!-- ������ secondPag.jsp�� �����Ͽ� secondPage.jsp�� ������ �ȴ�.  -->
	<%
		response.sendRedirect("secondPage.jsp");
	%>
	
</body>
</html>