package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,Long> {

    Optional<Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);

    /*   @Query(nativeQuery = true,value = "SELECT * FROM Driver WHERE id = :id AND license_number = :license") //raw mysql query and error is thrown at runtime if query has issue
    Optional<Driver> rawFindByIdAndLicenseNumber(Long id, String license);

    @Query("FROM Driver as d WHERE d.id = :id AND d.licenseNumber= :ln") //It is Hibernate Query , errors are thrown at compile time, hence it is better
    Optional<Driver> hqlFindByIdAndLicense(Long id, String ln);
    */

    List<Driver> findAllByIdIn(List<Long> driverIds);


}
