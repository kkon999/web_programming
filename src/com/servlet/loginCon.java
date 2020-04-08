package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.corba.se.spi.activation.Repository;


@WebServlet("/loginCon")
public class loginCon extends HttpServlet {
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// login.jsp에서 mID,mPW에 입력된 데이터를  전달 받음
		PrintWriter out =response.getWriter();
		
		String mId= request.getParameter("mID");
		String mPw = request.getParameter("mPW");
		
		// mId,pPw 데이터를 출력
		out.print("mId : " + mId);
		out.print("mPw : " + mPw);
		
		// 배열로 받는 Cookie[]와 저장되어 있지 않은 null을 위한 Cookie선언
		// 쿠키는 사용자쪽에 저장이 된다 그 이유는 request에 의해 만들어지기 때문이다
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;

		
		// for문을 통해 입력된 memberId의 데이터가 cookies에 존재하는지 확인
		for(Cookie c :cookies) {
			System.out.println("c.getName(): " + c.getName()+ "c.getValue(): " + c.getValue());
			
		// 입력된 memberId 값이 getName()과 일치하는것이 있으면 이전에 로그인 한 기록이 있는것이므로 하기 loginOk.jsp로 이동
		  if(c.getName().equals("memberId")) {
				cookie = c;
			}
		}
		// 입력된 memberId 값이 존재 하지 않는다면 memberId에 입력된 데이터를 cookie에 저장 후 하기 loginOk.jsp로 이동 
		  if(cookie == null) {
			System.out.println("cookie is null");
			cookie = new Cookie("memberId", mId);
		    }
		// 쿠키는 클라이언트에 있기 때문에 서버로 response를 통해 전달
		response.addCookie(cookie);
		// 쿠기가 유효한 만료 시간을 설정 1시간
		cookie.setMaxAge(60 * 60);
		
		// login.jsp로 전달
		response.sendRedirect("loginOk.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
