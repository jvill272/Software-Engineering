package com.CEN4010GROUP22.GeekText.ratings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingsController {

    private final RatingsService ratingService;
    
    @Autowired
    public RatingsController(RatingsService ratingService){
        this.ratingService = ratingService;
    }

    // retrieve all ratings in database
    @GetMapping(path = "ratings")
	public List<Ratings> getRatings(){
        System.out.println("\nGET Request for ratings is successful.");
        
        return ratingService.getRatings(); // returns all ratings currently in the database
    }

    // create a new rating in database
    @PostMapping(path = "ratings")
    public void addNewRating(@RequestBody Ratings rating){
        System.out.println("\nRequest body: " + rating);
        
        ratingService.addNewRating(rating);
    }

    // retrieve the average rating for a book based on path variable
    @GetMapping(path = "ratings/average/{book}")
    public double avgRatingOfBook(@PathVariable("book") String book){
        System.out.println("\nCalculating the average rating of " + book + ".");

        return ratingService.getAverageRatingOfBook(book);
    }

    // retrieve a sorted list(by highest rating) of ratings and comments for a book based on path variable
    @GetMapping(path = "ratings/sorted/{book}")
    public List<Object> sortedListOfRatingsAndComments(@PathVariable("book") String book){
        System.out.println("\nRetrieving a sorted list(by highest rating) of ratings and comments for " + book + ".");

        return ratingService.getSortedListOfRatingsAndComments(book);
    }

}