<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	
	<!-- 한 번 로그인 한 사용자에 대해서 저장된 cookie가 있으면 재로그인을 하지 않고 loginOk.jsp로 이동   -->
	<%
		Cookie[] cookies= request.getCookies();
		System.out.println("cookies : " + cookies);
		if(cookies != null){
			for(Cookie c : cookies){
				if(c.getName().equals("memberId")){
					response.sendRedirect("loginOk.jsp");
				}
			}
		}
	%>
	
	<!-- Login 기능 생성  -->
	<!-- mID,mPW 작성 후 login버튼 클릭 시 해당 데이터는 loginCon서블릿으로 전달 -->
	<form action ="loginCon"method ="post">
		ID : <input type = "text" 	  name = "mID"><br>
		PW : <input type = "password" name = "mPW"><br>
		<input type = "submit" value ="login"><br>
	</form>
</body>
</html>