package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter

public abstract class BaseModel {
    //abstract class so that no one can create an object of BaseModel Class as it is just code level segregation
    @Id //This annotation makes Id property a primary key of our table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity  means auto increment
    protected Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) //this annotation tells spring about the format of date object to be stored i.e. date, time or timestamp
    @CreatedDate //this annotation tells spring that only handle it for object creation
    protected Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate  ///this annotation tells spring that only handle it for object update
    protected Date updatedAt;
}
