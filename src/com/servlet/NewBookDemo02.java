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
		
		// Oracle Driver 위치  
		String driver = "oracle.jdbc.driver.OracleDriver";
		// Oracle 위치
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// Oracle 접속 계정명
		String id  = "scott";
		// Oracle 접속 패스워드		
		String pw  = "tiger";
		
		// java와 Oracle 연결 객체
		Connection con = null;
		// query 통신 객체 
		Statement stmt = null;
		// sql 명령에 대한 데이터를 반환해주는 객체
		ResultSet res  = null;
		
		try {
			// 드라이버 로딩
			Class.forName(driver);
			// 연결 객체 생성 (url,id,pw) 값이 일치해야함
			con = DriverManager.getConnection(url,id,pw);
			// 전송 객체 생성
			stmt = con.createStatement();
			String sql = "SELECT * FROM BOOK";
			// executeQuery는 데이터 조회시 사용
			res = stmt.executeQuery(sql);
			
			// while문을 사용하여 Database 테이블에서 지정된 데이터를 호출하여 출력
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
