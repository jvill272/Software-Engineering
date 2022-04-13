package com.CEN4010GROUP22.GeekText.books;

import java.io.Serializable;

public class BooksId implements Serializable {
    private String isbn;
    private String author;

    public BooksId() {
        ;
    }

    public BooksId(String bookIsbn, String bookAuthor) {
        this.isbn = bookIsbn;
        this.author = bookAuthor;
    }
}

