<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<%@include file="world.jsp" %> <%-- include 를 사용하여 다른 .jsp 파일 삽입 --%>
	
	<!-- 선언태그 -->
	<%!
		int num = 10;
		String str = "jsp";
		ArrayList<String>	list = new ArrayList<String>();
		
		public void jspMethod(){
			System.out.println(" -- jspMethod() --");
		}
	%>
	<!-- 주석 태그 -->
	<!-- 여기는 주석 입니다. -->
	<%-- Hello JSP --%>
	
	<!-- 스크립트릿 태그 -->
	<%
	if(num >0){
	%>
	<p>num > 0 </p>
	<%
	}else{
	%>
	<p>num <= 0 </p>
	<%
	}
	%>
	
	<!-- 표현식 태그 -->
	num is <%= num %>
	
	
	<%@include file="Hello.jsp"%> <%-- include 를 사용하여 다른 .jsp 파일 삽입 --%>
		
</body>
</html>