<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 변수를 선언 -->
	<%! 
	String adminId;
	String adminPw;
	
	String imgDir;
	String testServerIP;
	String realServerIP;
	
	%>
    
    <!-- config 객체의 경우 web.xml에서 지정된 .jsp만 사용 가능-->		
	<!-- servlet이 초기화 될 때 adminId,adminPw를 호툴  -->
	<%
	adminId = config.getInitParameter("adminId");
	adminPw = config.getInitParameter("adminPw");
	%>
	
	<!-- Application 객체 모든 application .jsp에서 사용 가능-->
	<%
	imgDir = application.getInitParameter("imgDir");
	testServerIP = application.getInitParameter("testServerIP");
	realServerIP = application.getInitParameter("realServerIP");
	%>	
	
	<p>adminID : <%= adminId%></p>
	<p>adminPW : <%= adminPw%></p>
	
	<p>imgDir : <%= imgDir%></p>
	<p>testServerIP : <%= testServerIP%></p>
	<p>realServerIP : <%= realServerIP%></p>
	
</body>
</html>