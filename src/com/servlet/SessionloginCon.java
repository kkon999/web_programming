package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/sessionloginCon")
public class SessionloginCon extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션 출력 객체 생성
		PrintWriter out = response.getWriter();
		
		String mID = request.getParameter("mID");
		String mPW = request.getParameter("mPW");
		
		out.print("mID :" + mID);
		out.print("mPW :" + mPW);
		
		// request 객체를 통해 사용자로부터 mID 데이터를 통해 session 생성 후 저장
		HttpSession session = request.getSession();

		// mID 에 입력받은 데이터를 저장 
		session.setAttribute("memberId", mID);
		
		// 로그인이 된 결과 화면으로 전달
		response.sendRedirect("SessionloginOk.jsp");
    
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
