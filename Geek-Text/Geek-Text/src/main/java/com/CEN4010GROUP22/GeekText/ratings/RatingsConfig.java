package com.CEN4010GROUP22.GeekText.ratings;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RatingsConfig {
    
    // @Bean
    // CommandLineRunner commandLineRunner(RatingsRepository repository){
    //     return args -> {
    //         Ratings rating1 = new Ratings(
	// 			2,
	// 			LocalDate.of(2022,Month.JANUARY, 15),
	// 			"BWAT001",
    //             "Pet Semetary"
	// 		);

    //         Ratings rating2 = new Ratings(
	// 			4,
	// 			LocalDate.of(2022,Month.FEBRUARY, 10),
	// 			"JVIL272",
    //             "Pet Semetary"
	// 		);

    //         repository.saveAll(
    //             List.of(rating1, rating2)
    //         );
    //     };
    // }
}