package com.CEN4010GROUP22.GeekText.ratings;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "ratings")
@IdClass(RatingsId.class)
public class Ratings implements Serializable {
    // instance variables representing the fields/attributes
    @Column(name = "rating", nullable = false, columnDefinition = "integer") // indicates the column and the data type in the table
    private int rating;
    
    @Column(name = "rating_date", nullable = false, columnDefinition = "date")
    private LocalDate ratingDate;

    @Id
    @Column(name = "fk_book_rater", columnDefinition="text")
    private String raterName;
    
    @Id
    @Column(name = "fk_rating_bname", columnDefinition="text")
    private String bookName;

    // constructors
    public Ratings(){
        ;
    }

    public Ratings(int rating, LocalDate ratingDate, String raterName, String bookName){
        this.rating = rating;
        this.ratingDate = ratingDate;
        this.raterName = raterName;
        this.bookName = bookName;
    }

    // setters and getters
    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDate getRatingDate() {
        return this.ratingDate;
    }

    public void setRatingDate(LocalDate ratingDate) {
        this.ratingDate = ratingDate;
    }

    public String getRaterName() {
        return this.raterName;
    }

    public void setRaterName(String raterName) {
        this.raterName = raterName;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    // toString method
    @Override
    public String toString() {
        return "{" +
            " rating='" + getRating() + "'" +
            ", ratingDate='" + getRatingDate() + "'" +
            ", raterName='" + getRaterName() + "'" +
            ", bookName='" + getBookName() + "'" +
            "}";
    }

}
