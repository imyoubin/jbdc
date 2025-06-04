package com.javaex.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.ex01.AuthorVO;

public class BookSelect {

	public static void main(String[] args) {
		
		List<BookVO> aList = new ArrayList<BookVO>(); 
		
		// 0. import java.sql.*;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
				 // 1. JDBC 드라이버 (Oracle) 로딩
					Class.forName("com.mysql.cj.jdbc.Driver");
				// 2. Connection 얻어오기
					String url = "jdbc:mysql://localhost:3306/web_db";
					conn = DriverManager.getConnection(url, "web", "web");

				 // 3. SQL문 준비 / 바인딩 / 실행
				 
					// SQL문 준비 
					String query = "";
					query+=" book_id, ";
					query+=" book_title,";
					query+=" book_pubs, ";
					query+=" book_pubDate, ";
					query+=" book_authorId, ";
					query+=" book_name, ";
					query+=" book_desc ";
					
					// 바운딩
					pstmt = conn.prepareStatement(query);
					
					// 실행
					rs = pstmt.executeQuery();
				 // 4.결과처리
					while(rs.next()) {
						int book_id = rs.getInt("book_id");
						String book_title = rs.getString("book_title");
						String book_pubs = rs.getString("ook_pubs");
						String book_pubDate = rs.getString("book_pubDate");
						String book_authorId = rs.getString("book_authorId");
						String book_name = rs.getString("book_name");
						String book_desc = rs.getString("book_desc");
						
						BookVO bookVO = new BookVO(book_id,book_title,book_pubs,book_pubDate,book_authorId,book_name,book_desc);
						
					}
					
				} catch (ClassNotFoundException e) {
				 System.out.println("error: 드라이버 로딩 실패 - " + e);
				} catch (SQLException e) {
				System.out.println("error:" + e);
				} finally {
				 
				// 5. 자원정리
				try {
				if (rs != null) {
				rs.close();
				 } 
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

			}

		}
