package com.javaex.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookSelectAll {

	public static void main(String[] args) {

		//리스트
		List<BookAuthorVO> baList = new ArrayList<BookAuthorVO>();
		
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. JDBC 드라이버 (MySQL) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/web_db";
			conn = DriverManager.getConnection(url, "web", "web");
			
			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " select 	bo.book_id, ";
			query += "		    bo.title, ";
			query += "          bo.pubs, ";
			query += "          date_format(bo.pub_date, '%Y-%m-%d') as pub_date, ";
			query += "          au.author_id, ";
			query += "          au.author_name, ";
			query += "          au.author_desc ";
			query += " from book bo, author au ";
			query += " where bo.author_id = au.author_id ";
			//System.out.println(query);
			
			
			// 바인딩
			pstmt = conn.prepareStatement(query);
			
			// 실행
			rs  = pstmt.executeQuery();
			
			// 4.결과처리
			while(rs.next()) {
				int bookId = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pubDate = rs.getString("pub_date");
				int authorId = rs.getInt("author_id");
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString("author_desc");
				
				BookAuthorVO baVo= new BookAuthorVO(bookId, title, pubs, pubDate, authorId, authorName, authorDesc);
				baList.add(baVo);
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
		
		/*
		for(int i=0; i<baList.size(); i++) {
			BookAuthorVO baVo = baList.get(i);
			System.out.println(baVo.getBookId()+", "+ baVo.getTitle() + ", " + baVo.getAuthorName());
		}
		*/
		

		for(BookAuthorVO baVo : baList) {
			System.out.println(baVo.getBookId()+", "+ baVo.getTitle() + ", " + baVo.getAuthorName());
		}
		
		
	}

}