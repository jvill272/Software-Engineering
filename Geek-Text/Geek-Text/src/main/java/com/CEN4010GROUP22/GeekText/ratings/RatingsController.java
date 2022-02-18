package com.CEN4010GROUP22.GeekText.ratings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "ratings")
public class RatingsController {

    private final RatingsService ratingService;
    
    @Autowired
    public RatingsController(RatingsService ratingService){
        this.ratingService = ratingService;
    }

    @GetMapping
	public List<Ratings> getRatings(){
        System.out.println("GET Request is successful.");
        
        return ratingService.getRatings(); // returns all ratings currently in the database
    }

    @PostMapping
    public void addNewRating(@RequestBody Ratings rating){
        System.out.println("\nRequest body: " + rating + "\n");
        
        ratingService.addNewRating(rating);
    }

}