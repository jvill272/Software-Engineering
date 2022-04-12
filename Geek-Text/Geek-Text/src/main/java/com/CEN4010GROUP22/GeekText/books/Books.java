package com.CEN4010GROUP22.GeekText.books;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

public class Books {
    @Id
    @Column(name = "book_id", nullable = false, columnDefinition = "text")
    private String isbn;

    @Column(name = "book_name", nullable = false, columnDefinition = "text")
    private String bookName;

    @Column(name = "book_des", nullable = false, columnDefinition = "text")
    private String description;

    @Column(name = "book_price", columnDefinition = "decimal")
    float price;

    @Id
    @Column(name = "fk_author_name", columnDefinition = "text")
    private String author;

    @Column(name = "book_genre", columnDefinition = "text")
    private String genre;

    @Column(name = "book_publisher", columnDefinition = "text")
    private String publisher;

    @Column(name = "book_year", columnDefinition = "int")
    private String yearPublished;

    @Column(name = "book_sales", columnDefinition = "integer")
    private int copiesSold;

    public Books(String isbn, String bookName, String description, float price, String author, String genre, String publisher, String yearPublished, int copiesSold) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.description = description;
        this.price = price;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
    }

    // toString method
    @Override
    public String toString() {
        return "";
    }

}