package com.javaex.ex05;

import java.util.List;

public class BookApp {

    public static void main(String[] args) {
        // DAO 객체 생성
        BookDAO bookDAO = new BookDAO();

        // 책 등록,수정, 삭제, 조회 등 호출 예시
        
        //책 등록
        int b01 = bookDAO.bookInsert("J.R.R. 톨킨", "반지의 제왕");
        System.out.println("등록된 건수: " + b01);
        //책 수정 
        int b02 = bookDAO.bookUpdate(5, "J.K. 롤링", "헤리포터");
       
        //책 삭제
       // int b03 = bookDAO.bookDelete(7);
        
        //전체조회
       // int b04 = bookDAO.bookSelect(); 
        
        //
        // int b05 = bookDAO.bookSelectOne(); 

        // 책 리스트 조회 bookDAO.bookSelectList() --> 전제조회
        List<BookAuthorVO> baList = bookDAO.bookSelectList();

     // 리스트 출력
     for (BookAuthorVO vo : baList) {
         System.out.println(vo.getBookId() + ". " + vo.getBookName() + " (" + vo.getBookDesc() + ") - " + vo.getAuthorName() + " / " + vo.getAuthorDesc());
     }
        
    	
    	//--BookAuthorVO  book, author테이블 조인
    	for (BookAuthorVO vo : baList) {
    System.out.println("책 ID: " + vo.getBookId());
    System.out.println("책 제목: " + vo.getBookName());
    System.out.println("책 설명: " + vo.getBookDesc());
    System.out.println("작가: " + vo.getAuthorName());
    System.out.println("작가 설명: " + vo.getAuthorDesc());
    System.out.println("----------------------------");
}
    	
    	
    }
}