package com.javaex.ex05;

public class BookAuthorVO {

    // 필드: book + author 테이블 컬럼들
    private int bookId;
    private String bookName;
    private String bookDesc;
    private int authorId;
    private String authorName;
    private String authorDesc;

    // 생성자
    public BookAuthorVO() {}

    public BookAuthorVO(int bookId, String bookName, String bookDesc,
                        int authorId, String authorName, String authorDesc) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookDesc = bookDesc;
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorDesc = authorDesc;
    }

    // Getter & Setter
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorDesc() {
        return authorDesc;
    }

    public void setAuthorDesc(String authorDesc) {
        this.authorDesc = authorDesc;
    }

    // toString() for debugging
    @Override
    public String toString() {
        return bookId + ". " + bookName + " (" + bookDesc + ") - " +
               authorName + " / " + authorDesc;
    }
}