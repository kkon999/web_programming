package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NewBookDemo01")
public class NewBookDemo01 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset =UTF-8");
		PrintWriter out = response.getWriter();
		
		String bookName = request.getParameter("book_name");
		String bookLoc = request.getParameter("book_loc");
		
		// Oracle Driver ��ġ  
		String driver = "oracle.jdbc.driver.OracleDriver";
		// Oracle ��ġ
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// Oracle ���� ������
		String id  = "scott";
		// Oracle ���� �н�����		
		String pw  = "tiger";
		
		// java�� Oracle ���� ��ü
		Connection con = null;
		// query ��� ��ü 
		Statement stmt = null;
		
		try {
			// ����̹� �ε�
			Class.forName(driver);
			// ���� ��ü ���� (url,id,pw) ���� ��ġ�ؾ���
			con = DriverManager.getConnection(url,id,pw);
			// ���� ��ü ����
			stmt = con.createStatement();		
			// query�� �ۼ�
			String sql = "INSERT INTO BOOK(BOOK_ID, BOOK_NAME, BOOK_LOC)";
					sql += "VALUES (BOOK_SEQ.NEXTVAL, '" + bookName + "','" + bookLoc + "')";
			// stmt ��� ��ä�� ����Ͽ� Database�κ��� ���� ���� �����͸�  result�� ��Ƽ� ������ ����
			// executeUpdate�� ������ ����,����,������ ���
			int result =stmt.executeUpdate(sql);
			
			// result�� ���� �����̸� ������ INSERT�Ǹ�  INSERT success!! ���� ���
			if(result == 1) {
				out.print("INSERT success!!");
			}else{
				out.print("INSERT fail!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			// query Update�� ����,���۰�ü���� ����� �ڿ��� ��ȯ
			finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
				}catch (Exception e2) {
					e2.printStackTrace();
			}
		}
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
