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
		
		try {
			// 드라이버 로딩
			Class.forName(driver);
			// 연결 객체 생성 (url,id,pw) 값이 일치해야함
			con = DriverManager.getConnection(url,id,pw);
			// 전송 객체 생성
			stmt = con.createStatement();		
			// query문 작성
			String sql = "INSERT INTO BOOK(BOOK_ID, BOOK_NAME, BOOK_LOC)";
					sql += "VALUES (BOOK_SEQ.NEXTVAL, '" + bookName + "','" + bookLoc + "')";
			// stmt 통신 객채를 사용하여 Database로부터 전달 받은 데이터를  result에 담아서 서버로 전달
			// executeUpdate는 데이터 수정,삽입,삭제시 사용
			int result =stmt.executeUpdate(sql);
			
			// result는 행의 개수이며 쿼리가 INSERT되면  INSERT success!! 문구 출력
			if(result == 1) {
				out.print("INSERT success!!");
			}else{
				out.print("INSERT fail!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			// query Update후 연결,전송객체에서 사용한 자원을 반환
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
