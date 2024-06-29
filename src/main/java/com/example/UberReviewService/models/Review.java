package com.example.UberReviewService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Review {

    @Id //This annotation makes the Id property a primary key of our table
    Long id;
}
