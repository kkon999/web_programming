<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- NewBook 서블릿에 post 형식으로  book name,book location을 전달하는 form 생성-->
	<form action = "NewBookDemo01" method = "post">
		book name : <input type ="text" name = "book_name"><br>
		book location : <input type ="text" name = "book_loc"><br>
		<input type ="submit" value ="book register">
	</form>
	
</body>
</html>