package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "BookingReview")

public class Review {

    @Id //This annotation makes the Id property a primary key of our table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity  means auto increment
    private Long id;

    @Column(nullable = false)
    private String content;

    private Double rating;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) //this annotation tells spring about the format of date object to be stored i.e date, time or timestamp
    @CreatedDate //this annotation tells spring that only handle it for object creation
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate  ///this annotation tells spring that only handle it for object update
    private Date updatedAt;

    @Override
    public String toString(){
        return "Review: " + this.content + " " +this.rating + this.createdAt;
    }


}
