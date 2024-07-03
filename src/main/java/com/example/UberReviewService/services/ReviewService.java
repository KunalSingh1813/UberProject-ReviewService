package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {

    @Autowired
    private ReviewRepository reviewRepository;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("inside ReviewService----------");
        Review r = Review.builder()
                .content("Good ride quality")
                .rating(4.0).build(); //code to create plain java object
        System.out.println(r);
        reviewRepository.save(r); //implemented by JpaRepository

        List<Review> reviews = reviewRepository.findAll();

        for(Review review: reviews){
            System.out.println(r.getContent());
        }

    }
}
