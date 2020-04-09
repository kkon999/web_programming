
<!-- encoding.jsp에서 post방식으로인코딩 데이터 전달시 하기와 같이 <%request.setCharacterEncoding("UTF-8");%> 선언 -->
<%request.setCharacterEncoding("UTF-8");%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		
		<%!
		String mName;
		String mNickame;
		%>
		
		<%
			mName   = request.getParameter("m_name");
			mNickame= request.getParameter("m_nickname");
		%>
		
		이름 : <%= mName%>
		<br>
		별명 : <%= mNickame%>
		
</body>
</html>