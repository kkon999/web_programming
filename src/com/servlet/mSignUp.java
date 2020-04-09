package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mSignUp")
public class mSignUp extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// post 방식일때 한글처리 선언
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset =UTF-8");
		
		PrintWriter out = response.getWriter();
		String Mname = request.getParameter("m_name");
		String Mnickname = request.getParameter("m_nickname");

		out.print("<p>m_name  	  : " + Mname + "</p>");
		out.print("<p>m_nickname : " + Mnickname + "</p>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
