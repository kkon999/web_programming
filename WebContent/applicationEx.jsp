<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page errorPage = "errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
    <!-- 변수를 선언 -->
	<%!
		String imgDir;
		String testServerIP;
		String realServerIP;
		
		String connectedIP;
	 	String connectedUser;
	 	
	 	String str;
	%>
		
	<!-- Application 객체 -->
	<%
		imgDir = application.getInitParameter("imgDir");
		testServerIP = application.getInitParameter("testServerIP");
		realServerIP = application.getInitParameter("realServerIP");
	%>
	
	<p>imgDir : <%= imgDir%></p>
	<p>testServerIP : <%= testServerIP%></p>
	<p>realServerIP : <%= realServerIP%></p>
	
	
	<!-- application 객체를 사용해 setAttribute connectedIP 와  connectedUser를 저장 -->
	<%
		application.setAttribute("connectedIP", "165.62.58.23");
		application.setAttribute("connectedUser", "HONG");
	%>
	
	<!-- out 객체 -->
	
	<%
		out.print("<h1>Hello JAVA World!!</h1>");
		out.print("<h2>Hello JAVA World!!</h2>");
		out.print("<h3>Hello JAVA World!!</h3>");
	%>
	
	<!-- exception 객체 -->
	<%
		out.print(str.toString());
	%>
	
	
</body>
</html>