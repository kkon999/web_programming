package com.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.servlet.dto.BookDTO;
import com.sun.org.apache.bcel.internal.generic.Select;

public class BookDAO {
	
	
	// Oracle ����̹�,��ġ,���� ���� �Է� 
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "scott";
	String pw = "tiger";
	
	
	// Oracle ����̹� �ε�
	public BookDAO() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BookDTO> select() {
		
		// BookDTO.java���� ���� ���� �����͸� ArrayList�� ����
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
				
		// java�� Oracle ���� ��ü ����
		Connection con = null;
		// Query ��� ��ü ����
		PreparedStatement pstmt = null;
		// ������ ��ȸ ��ü ����
		ResultSet res = null;
		
		try {
			// ���� ��ü(url,id,pw)
			con = DriverManager.getConnection(url, id, pw);
			// Query�� �ۼ�
			String sql = "SELECT * FROM book";
			// Query ��� ��ü
			pstmt = con.prepareStatement(sql);
			// ��ȸ �����͸� ��ȯ ��ü
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
