package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NewBookDemo01_modify")
public class NewBookDemo01_modify extends HttpServlet {

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
		
		//연결 객체 생성
		Connection con = null;
		//전송 객체 생성
		PreparedStatement pstmt = null;
		
		try {
			// 드라이버 로딩
			Class.forName(driver);
			// 연결 객체 생성 (url,id,pw) 값이 일치해야함
			con = DriverManager.getConnection(url,id,pw);
			
			String sql = "UPDATE BOOK SET BOOK_LOC = ? WHERE BOOK_NAME = ?";
			
			// 전송 객체 생성
			pstmt = con.prepareStatement(sql);
			
			// sql 구문에 ?에 순서대로 입력될 데이터 작성
			pstmt.setString(1,"001-00007123");
			pstmt.setString(2,"book7");
			
			// executeUpdate는 데이터 수정,삽입,삭제시 사용
			int result = pstmt.executeUpdate();
			
			// result는 행의 개수이며 쿼리가 UPATAE되면  INSERT success!! 문구 출력
			if(result == 1) {
				out.print("UPATAE success!!");
			}else {
				out.print("UPATAE fail!");
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
				// query Update후 연결,전송객체에서 사용한 자원을 반환
				finally {
				try {
					if(pstmt != null) pstmt.close();
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
