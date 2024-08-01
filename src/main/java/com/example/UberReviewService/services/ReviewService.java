package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.DriverRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class ReviewService implements CommandLineRunner {


    private ReviewRepository reviewRepository;

    private final BookingRepository bookingRepository;

    private final DriverRepository driverRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository, DriverRepository driverRepository){this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("inside ReviewService----------");
//        Review r = Review.builder()
//                .content("Good ride quality")
//                .rating(4.0).build(); //code to create plain java object
//
//        Booking b = Booking
//                    .builder()
//                    .endTime(new Date())
//                    .review(r)
//                    .build();
//
//        bookingRepository.save(b);
//
//
//          System.out.println(r);
//        reviewRepository.save(r); //implemented by JpaRepository
//        System.out.println(r.getId());
//
//        List<Review> reviews = reviewRepository.findAll();
//
//        for(Review review: reviews){
//            System.out.println(r.getContent());
//        }

       // List<Driver> drivers = driverRepository.findAll();

//        Optional<Driver> driver = driverRepository.findById(1L);
//        if(driver.isPresent()){
//            System.out.println(driver.get().getName());
//           List<Booking> b = driver.get().getBookings();
//            List<Booking> bookings = bookingRepository.findAllByDriverId(1L);
//            for(Booking booking : b){
//                System.out.println(booking.getId());
//            }


//        }
//        Optional<Booking> b = bookingRepository.findById(1L);
//        Optional<Driver> d = driverRepository.hqlFindByIdAndLicense(1L,"DL121212");
//        System.out.println(d.get().getName());

        List<Long> driverIds = new ArrayList<>(Arrays.asList(1L,2L));
        List<Driver> drivers = driverRepository.findAllByIdIn((driverIds));

        //One solution to N+1 problem
     //   List<Booking> bookings = bookingRepository.findAllByDriverIn(drivers);


        for (Driver driver : drivers) {
            List<Booking> bookings = driver.getBookings();
            bookings.forEach(booking -> System.out.println(booking.getId()));
        }
    }
}
