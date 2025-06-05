package com.javaex.ex05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {
	
	//필드
		private Connection conn = null;
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;
		
		private String driver = "com.mysql.cj.jdbc.Driver";
		private String url = "jdbc:mysql://localhost:3306/web_db";
		private String id = "web";
		private String pw = "web";

		public BookDAO() {}

		//DB연결 메소드-공통
		private void connect() {    //메인에서는 사용하지 못함
			
			try {
				// 1. JDBC 드라이버 (MySQL) 로딩
				Class.forName(driver);

				// 2. Connection 얻어오기
				this.conn = DriverManager.getConnection(url, id, pw);
				
			} catch (ClassNotFoundException e) {
				System.out.println("error: 드라이버 로딩 실패 - " + e);
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
			
		}
		
		//자원정리 메소드-공통
		private void close() {
			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}
		
		//책 등록
		public int bookInsert(String name, String desc) {
			int count = -1;
			
			// 0. import java.sql.*;
			
			// 1. JDBC 드라이버 (MySQL) 로딩
			// 2. Connection 얻어오기
			this.connect();
			
			try {
				
				// 3. SQL문 준비 / 바인딩 / 실행
				//SQL문 준비 
				String query = "";
				query += " insert into book ";
				query += " values(null, ?, ?) ";
				System.out.println(query);
				
				//바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, name);   //메소드의 파라미터
				pstmt.setString(2, desc);   //메소드의 파라미터

				//실행
				count = pstmt.executeUpdate();
				
				// 4.결과처리
				
			} catch (SQLException e) {
				System.out.println("error:" + e);
			} 
			
			// 5. 자원정리
			this.close();
			
			return count;
		}
}
