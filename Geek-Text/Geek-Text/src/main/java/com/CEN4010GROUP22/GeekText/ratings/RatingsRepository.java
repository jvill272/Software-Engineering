package com.CEN4010GROUP22.GeekText.ratings;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingsRepository extends JpaRepository<Ratings, RatingsId> {
    
    // @Query("SELECT r FROM Ratings r WHERE r.fk_book_rater = ?1 AND r.fk_rating_bname = ?2")
    // Optional<Rating> findRatingByRaterNameAndBookName(String rater,String bookName);

    List<Ratings> findRatingByRaterNameAndBookName(String fk_book_rater, String fk_bname);
}