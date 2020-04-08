<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<!-- loginCon에서  전달 받은 cookies의 값을 출력-->
	<% 
		Cookie[] cookies = request.getCookies();
	for(Cookie c : cookies){
		out.print("name :" + c.getName()+ "<br>");
		out.print("Value :" + c.getValue()+ "<br>");
		out.print("================================");
	}
	
	%>
</body>
</html>