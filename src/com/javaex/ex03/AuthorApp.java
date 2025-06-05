package com.javaex.ex03;

import java.util.List;

//메인프로그램
public class AuthorApp {

	public static void main(String[] args) {
			
		AuthorDAO  authorDAO = new AuthorDAO();
		
		/*
		int count = authorDAO.authorInsert("주호민", "웹툰작가");
		if(count>0) {
			System.out.println("등록되었습니다.");
		}else if(count<0) {
			System.out.println("알수없는 오류발생");
		}else {
			System.out.println("등록되지 않았습니다.");
		}
	
		authorDAO.authorInsert("김영하", "알쓸신잡 출연");
		authorDAO.authorInsert("기안84", "방송대상 수장");
		*/
		
		
		//authorDAO.authorDelete(7);
		
		//authorDAO.authorUpdate(2, "한강", "노벨상수상");
		
		List<AuthorVO> authorList = authorDAO.authorList();
		
		//사용자용 출력화면
		for(int i=0; i<authorList.size(); i++) {
			AuthorVO authorVO = authorList.get(i);
			System.out.println(authorVO.getAuthorId() + ". " +authorVO.getAuthorName() + "(" + authorVO.getAuthorDesc()  + ")" );
		}
	
		
		/*
		1. 이문열(경북영양)
		2. 한강(노벨상 수상)
		*/
	}

}