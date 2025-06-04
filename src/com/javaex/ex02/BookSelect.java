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
						int bookid = rs.getInt("book_id");
						String booktitle = rs.getString("book_title");
						String bookpubs = rs.getString("ook_pubs");
						String bookpubDate = rs.getString("book_pubDate");
						String bookauthorId = rs.getString("book_authorId");
						String bookname = rs.getString("book_name");
						String bookdesc = rs.getString("book_desc");
						
						BookVO bookVO = new BookVO(bookid, booktitle, bookpubs, bookpubDate, bookauthorId, bookname, bookdesc);
						
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
				
				System.out.println("-----------------------------------------");
				for(int i=0; i<aList.size(); i++) {
					
					int bookid = aList.get(i).getBook_id();
					String booktitle = aList.get(i).getBook_title();
					String bookpubs = aList.get(i).getBook_pubs();
					String bookpubDate = aList.get(i).getBook_pubDate();
					String bookauthorId = aList.get(i).getBook_authorId();
					String bookname = aList.get(i).getBook_name();
					String bookdesc = aList.get(i).getBook_desc();
					
					System.out.println(bookid + ".  " +booktitle + "(" +bookpubs + ")");		
				}
				System.out.println("-----------------------------------------");
				
			}

		}
