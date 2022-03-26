package com.CEN4010GROUP22.GeekText.ratings;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingsRepository extends JpaRepository<Ratings, RatingsId> {

    // find a rating by rater name and book name
    List<Ratings> findRatingByRaterNameAndBookName(String fk_book_rater, String fk_bname);

    // retrieve the average rating for a specific book
    @Query("SELECT AVG(r.rating) FROM Ratings r WHERE r.bookName = ?1")
    double findAverageRatingOfBook(String bookName);

    // retrieve a sorted list(by highest rating) of ratings and comments for a specific book(ratings and comments matched by username and book name)
    @Query("SELECT r,c FROM Ratings r INNER JOIN Comments c ON (r.raterName = c.commenterName AND r.bookName = c.bookName) WHERE r.bookName = ?1 ORDER BY r.rating DESC")
    List<Object> sortRatingsAndCommentsByHighestRating(String bookName);
    
}