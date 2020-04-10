<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<!-- JSP에서 작성한 이름,별명을 서블릿으로 전달 -->
	<form action = "mSignUp" method ="post">
		이름 : <input type="text" name ="m_name"><br>
		별명 : <input type="text" name ="m_nickname"><br>
		<input type="submit" value = "sign up">
	
	<!-- JSP에서 작성한 이름,별명을 JSP로 전달-->
	<form action = "encoding_02.jsp" method ="post">
		이름 : <input type="text" name ="m_name"><br>
		별명 : <input type="text" name ="m_nickname"><br>
		<input type="submit" value = "sign up">
	</form>
</body>
</html>