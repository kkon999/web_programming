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
	
	<!-- ������ ���� -->
	<%! 
	String adminId;
	String adminPw;
	
	String imgDir;
	String testServerIP;
	String realServerIP;
	
	%>
    
    <!-- config ��ü�� ��� web.xml���� ������ .jsp�� ��� ����-->		
	<!-- servlet�� �ʱ�ȭ �� �� adminId,adminPw�� ȣ��  -->
	<%
	adminId = config.getInitParameter("adminId");
	adminPw = config.getInitParameter("adminPw");
	%>
	
	<!-- Application ��ü ��� application .jsp���� ��� ����-->
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