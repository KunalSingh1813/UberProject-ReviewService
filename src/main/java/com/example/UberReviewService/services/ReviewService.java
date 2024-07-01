package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("inside ReviewService----------");
        //Review r = Review.builder().content("Amazing ride quality").rating(5.0).build(); //code to create plain java object
        //reviewRepository.save(r);
    }
}
