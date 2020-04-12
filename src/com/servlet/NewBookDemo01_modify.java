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
		
		// Oracle Driver ��ġ  
		String driver = "oracle.jdbc.driver.OracleDriver";
		// Oracle ��ġ
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// Oracle ���� ������
		String id  = "scott";
		// Oracle ���� �н�����		
		String pw  = "tiger";
		
		//���� ��ü ����
		Connection con = null;
		//���� ��ü ����
		PreparedStatement pstmt = null;
		
		try {
			// ����̹� �ε�
			Class.forName(driver);
			// ���� ��ü ���� (url,id,pw) ���� ��ġ�ؾ���
			con = DriverManager.getConnection(url,id,pw);
			
			String sql = "UPDATE BOOK SET BOOK_LOC = ? WHERE BOOK_NAME = ?";
			
			// ���� ��ü ����
			pstmt = con.prepareStatement(sql);
			
			// sql ������ ?�� ������� �Էµ� ������ �ۼ�
			pstmt.setString(1,"001-00007123");
			pstmt.setString(2,"book7");
			
			// executeUpdate�� ������ ����,����,������ ���
			int result = pstmt.executeUpdate();
			
			// result�� ���� �����̸� ������ UPATAE�Ǹ�  INSERT success!! ���� ���
			if(result == 1) {
				out.print("UPATAE success!!");
			}else {
				out.print("UPATAE fail!");
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
				// query Update�� ����,���۰�ü���� ����� �ڿ��� ��ȯ
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
