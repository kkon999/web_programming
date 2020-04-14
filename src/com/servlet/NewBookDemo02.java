package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/NewBookDemo02")
public class NewBookDemo02 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset =UTF-8");
		PrintWriter out = response.getWriter();
		
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
		// sql ��ɿ� ���� �����͸� ��ȯ���ִ� ��ü
		ResultSet res  = null;
		
		try {
			// ����̹� �ε�
			Class.forName(driver);
			// ���� ��ü ���� (url,id,pw) ���� ��ġ�ؾ���
			con = DriverManager.getConnection(url,id,pw);
			// ���� ��ü ����
			stmt = con.createStatement();
			String sql = "SELECT * FROM BOOK";
			// executeQuery�� ������ ��ȸ�� ���
			res = stmt.executeQuery(sql);
			
			// while���� ����Ͽ� Database ���̺��� ������ �����͸� ȣ���Ͽ� ���
			while (res.next()) {
				int bookId = res.getInt("BOOK_ID");
				String bookName = res.getString("BOOK_NAME");
				String bookLoc = res.getString("BOOK_LOC");
				
				out.print("bookId: " + bookId + ", ");
				out.print("bookName : " + bookName + ", ");
				out.print("bookLoc : " + bookLoc + "<br>");
			}
		}
			catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(res != null) res.close();
					if(stmt != null) stmt.close();
					if(con != null) con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}			
			
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
