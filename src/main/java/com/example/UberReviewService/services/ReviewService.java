package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {


    private ReviewRepository reviewRepository;

    private final BookingRepository bookingRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository){this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("inside ReviewService----------");
        Review r = Review.builder()
                .content("Good ride quality")
                .rating(4.0).build(); //code to create plain java object

        Booking b = Booking
                    .builder()
                    .endTime(new Date())
                    .review(r)
                    .build();

        bookingRepository.save(b);


          System.out.println(r);
        reviewRepository.save(r); //implemented by JpaRepository
        System.out.println(r.getId());

        List<Review> reviews = reviewRepository.findAll();

        for(Review review: reviews){
            System.out.println(r.getContent());
        }

    }
}
