package com.company.booking.repository;

import com.company.booking.entity.Trip;
import org.springframework.data.jpa.repository. JpaRepository;

public interface  TripRepository extends JpaRepository<Trip,Long>{
    List<Trip>findByUserId(Long userId);
    List<Trip>findByUserId(String status);
    List<Trip>findByDestinationContainingIgnoreCase(String destination);
    List<Trip>findByStrartDateBetween(String start,String end);
}