package com.javaex.ex02;

public class BookVO {
	
	//필드
	private int book_id;
	private String book_title;
	private String book_pubs;
	private String book_pubDate;
	private String book_authorId;
	private String book_name;
	private String book_desc;
	
	//생성자
	public BookVO() {
	}


	public BookVO(int book_id, String book_title, String book_pubs, String book_pubDate, String book_authorId,
			String book_name, String book_desc) {
		this.book_id = book_id;
		this.book_title = book_title;
		this.book_pubs = book_pubs;
		this.book_pubDate = book_pubDate;
		this.book_authorId = book_authorId;
		this.book_name = book_name;
		this.book_desc = book_desc;
	}

	//메소드gs
	public int getBook_id() {
		return book_id;
	}


	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}


	public String getBook_title() {
		return book_title;
	}


	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}


	public String getBook_pubs() {
		return book_pubs;
	}


	public void setBook_pubs(String book_pubs) {
		this.book_pubs = book_pubs;
	}


	public String getBook_pubDate() {
		return book_pubDate;
	}


	public void setBook_pubDate(String book_pubDate) {
		this.book_pubDate = book_pubDate;
	}


	public String getBook_authorId() {
		return book_authorId;
	}


	public void setBook_authorId(String book_authorId) {
		this.book_authorId = book_authorId;
	}


	public String getBook_name() {
		return book_name;
	}


	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}


	public String getBook_desc() {
		return book_desc;
	}


	public void setBook_desc(String book_desc) {
		this.book_desc = book_desc;
	}

	//메소드일반
	@Override
	public String toString() {
		return "BookVO [book_id=" + book_id + ", book_title=" + book_title + ", book_pubs=" + book_pubs
				+ ", book_pubDate=" + book_pubDate + ", book_authorId=" + book_authorId + ", book_name=" + book_name
				+ ", book_desc=" + book_desc + "]";
	}

	
	

}
