package com.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.servlet.dto.BookDTO;
import com.sun.org.apache.bcel.internal.generic.Select;

public class BookDAO {
	
	
	// Oracle 드라이버,위치,접속 정보 입력 
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "scott";
	String pw = "tiger";
	
	
	// Oracle 드라이버 로딩
	public BookDAO() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BookDTO> select() {
		
		// BookDTO.java에서 전달 받은 데이터를 ArrayList에 저장
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
				
		// java와 Oracle 연결 객체 생성
		Connection con = null;
		// Query 통신 객체 생성
		PreparedStatement pstmt = null;
		// 데이터 조회 객체 생성
		ResultSet res = null;
		
		try {
			// 연결 객체(url,id,pw)
			con = DriverManager.getConnection(url, id, pw);
			// Query문 작성
			String sql = "SELECT * FROM book";
			// Query 통신 객체
			pstmt = con.prepareStatement(sql);
			// 조회 데이터를 반환 객체
			res = pstmt.executeQuery();
			
			while (res.next()) {
				int bookId = res.getInt("book_id");
				String bookName = res.getString("book_name");
				String bookLoc = res.getString("book_loc");
				
				BookDTO bookDTO = new BookDTO(bookId, bookName, bookLoc);
				list.add(bookDTO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
		
	}
}
