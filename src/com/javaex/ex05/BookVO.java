package com.javaex.ex05;

public class BookVO {
    private int bookId;
    private String bookName;
    private String bookDesc;

    public BookVO(int bookId, String bookName, String bookDesc) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookDesc = bookDesc;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookDesc() {
        return bookDesc;
    }
}