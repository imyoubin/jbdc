package com.javaex.ex05;

public class BookApp {

	//web_db   web/web
	//
	BookDAO bookDAO = new BookDAO();
	
	
	
	//BookVO  book테이블 전용
	int b01 = bookDAO.bookInsert("J.R.R. 톨킨","반지의 제왕");
	//int b02 = bookDAO.bookUpdate(5,"J.K. 롤링","헤리포터");
	//int b03 = bookDAO.bookDelete(7);
	//int b04 = bookDAO.bookSelect();
	//int b05 = bookDAO.bookSelectOne();
	
	/*
	----
	--BookAuthorVO  book, author테이블 조인
	bookDAO.bookSelectList() --> 전제조회
	*/
}