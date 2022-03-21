package com.CEN4010GROUP22.GeekText.ratings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingsService {
    
    @Autowired
    private final RatingsRepository ratingRepository;

    @Autowired
    public RatingsService(RatingsRepository ratingRepository){
        this.ratingRepository = ratingRepository;
    }

    // retrieves all current ratings in database
    public List<Ratings> getRatings(){
        return ratingRepository.findAll();
    }

    // creates a new rating in database
    public void addNewRating(Ratings rating){
        String rater = rating.getRaterName();
        String book = rating.getBookName();
        System.out.println("Rater: " + rater + "\nBook: " + book + "\n");

        List<Ratings> ratingSearched = ratingRepository.findRatingByRaterNameAndBookName(rater, book);

        System.out.println("ratingSearched: " + ratingSearched);

        if(!ratingSearched.isEmpty()){
            System.out.println("\nA rating for " + book + " from " + rater + " already exists. The new rating will not be saved.\n");
            
            // end method because a rating for this rater + book PK combination already exists -> should not be saved
            return;
        }

        // rating from the current (rater, bookName) combination PK does not exist yet -> save the rating to database
        ratingRepository.save(rating);
        System.out.println("\nNew rating saved to database.");
    }

    // retrieve the average rating for a book
    public double getAverageRatingOfBook(String bookName){
        double average = ratingRepository.findAverageRatingOfBook(bookName);
        System.out.println("\nAverage rating of " + bookName + " is " + average);

        return ratingRepository.findAverageRatingOfBook(bookName);
    }

}
