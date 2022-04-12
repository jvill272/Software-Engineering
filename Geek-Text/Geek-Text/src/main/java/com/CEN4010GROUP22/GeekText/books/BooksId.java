package com.CEN4010GROUP22.GeekText.books;

import java.io.Serializable;

public class BooksId implements Serializable {
    private String bookIsbn;
    private String bookAuthor;

    public BooksId() {
        ;
    }
    public BooksId(String bookIsbn, String bookAuthor) {
        this.bookIsbn = bookIsbn;
        this.bookAuthor = bookAuthor;
    }
}

