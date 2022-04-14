package com.CEN4010GROUP22.GeekText.books;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@IdClass(BooksId.class)


public class Books {
    @Id
    @Column(name = "book_id", columnDefinition = "text")
    private String isbn;

    @Column(name = "book_name", nullable = false, columnDefinition = "text")
    private String bookName;

    @Column(name = "book_des", nullable = false, columnDefinition = "text")
    private String description;

    @Column(name = "book_price", nullable = false, columnDefinition = "decimal")
    private float price;

    @Column(name = "book_genre", nullable = false, columnDefinition = "text")
    private String genre;

    @Column(name = "book_publisher", nullable = false, columnDefinition = "text")
    private String publisher;

    @Column(name = "book_year", columnDefinition = "int")
    private int yearPublished;

    @Column(name = "book_sales", columnDefinition = "integer")
    private int copiesSold;

    @Column(name = "author_name", nullable = false, columnDefinition = "text")
    private String author;

    public Books() {
        ;
    }

    public Books(String isbn, String bookName, String description, float price, String author, String genre, String publisher, int yearPublished, int copiesSold) {
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

    //Getters and Setters
    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    //Changed getBookName, to getBookDetailName to prevent methods having the same name.
    public String getBookDetailName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearPublished() {
        return this.yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getCopiesSold() {
        return this.copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    // toString method
    @Override
    public String toString() {
        return "{" +
                " isbn='" + getIsbn() + "'" +
                ", bookName='" + getBookDetailName() + "'" +
                ", description='" + getDescription() + "'" +
                ", price='" + getPrice() + "'" +
                ", author='" + getAuthor() + "'" +
                ", genre='" + getGenre() + "'" +
                ", publisher='" + getPublisher() + "'" +
                ", yearPublished='" + getYearPublished() + "'" +
                ", copiesSold='" + getCopiesSold() + "'" +
                "}";
    }
}