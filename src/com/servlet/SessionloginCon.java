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
		
		// ���� ��� ��ü ����
		PrintWriter out = response.getWriter();
		
		String mID = request.getParameter("mID");
		String mPW = request.getParameter("mPW");
		
		out.print("mID :" + mID);
		out.print("mPW :" + mPW);
		
		// request ��ü�� ���� ����ڷκ��� mID �����͸� ���� session ���� �� ����
		HttpSession session = request.getSession();

		// mID �� �Է¹��� �����͸� ���� 
		session.setAttribute("memberId", mID);
		
		// �α����� �� ��� ȭ������ ����
		response.sendRedirect("SessionloginOk.jsp");
    
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
