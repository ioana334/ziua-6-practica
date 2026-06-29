package com.company.booking.dto.response;

public record TripResponse(
    Long id;
    String destination;
    String startDate;
    String endDate;
    String status;
    Long userId; 
){}