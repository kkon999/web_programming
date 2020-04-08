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
		
		
		// login.jsp���� mID,mPW�� �Էµ� �����͸�  ���� ����
		PrintWriter out =response.getWriter();
		
		String mId= request.getParameter("mID");
		String mPw = request.getParameter("mPW");
		
		// mId,pPw �����͸� ���
		out.print("mId : " + mId);
		out.print("mPw : " + mPw);
		
		// �迭�� �޴� Cookie[]�� ����Ǿ� ���� ���� null�� ���� Cookie����
		// ��Ű�� ������ʿ� ������ �ȴ� �� ������ request�� ���� ��������� �����̴�
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;

		
		// for���� ���� �Էµ� memberId�� �����Ͱ� cookies�� �����ϴ��� Ȯ��
		for(Cookie c :cookies) {
			System.out.println("c.getName(): " + c.getName()+ "c.getValue(): " + c.getValue());
			
		// �Էµ� memberId ���� getName()�� ��ġ�ϴ°��� ������ ������ �α��� �� ����� �ִ°��̹Ƿ� �ϱ� loginOk.jsp�� �̵�
		  if(c.getName().equals("memberId")) {
				cookie = c;
			}
		}
		// �Էµ� memberId ���� ���� ���� �ʴ´ٸ� memberId�� �Էµ� �����͸� cookie�� ���� �� �ϱ� loginOk.jsp�� �̵� 
		  if(cookie == null) {
			System.out.println("cookie is null");
			cookie = new Cookie("memberId", mId);
		    }
		// ��Ű�� Ŭ���̾�Ʈ�� �ֱ� ������ ������ response�� ���� ����
		response.addCookie(cookie);
		// ��Ⱑ ��ȿ�� ���� �ð��� ���� 1�ð�
		cookie.setMaxAge(60 * 60);
		
		// login.jsp�� ����
		response.sendRedirect("loginOk.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
